package com.sample.actuproject

import android.app.Application
import com.sample.actuproject.api.service.ApiActuService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.sample.actuproject.data.navigator.Navigator

class ActuApplication: Application() {


    init {
        instance = this
    }

    companion object {
        private lateinit var apiActuService : ApiActuService
        private var instance: ActuApplication? = null

        fun instance(): Application {

            return instance!!
        }

        fun getApiMangaService() : ApiActuService {
            return apiActuService
        }
    }



    override fun onCreate() {
        super.onCreate()
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(logging)

        val builder = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(" https://test-pgt-dev.apnl.ws/")


        val retrofit = builder
            .client(
                httpClient.build()
            )
            .build()
        apiActuService = retrofit.create(ApiActuService::class.java)
        Navigator.instance().init()
    }



}