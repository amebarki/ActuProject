package com.sample.actuproject.api.service

import com.sample.actuproject.data.model.Actu
import com.sample.actuproject.data.model.RootObject
import com.sample.actuproject.data.model.Success
import io.reactivex.Single
import retrofit2.http.*

interface ApiActuService {


    @Headers(
        "X-AP-Key: uD4Muli8nO6nzkSlsNM3d1Pm",
        "X-AP-DeviceUID: trial",
        "Accept: application/json"
    )
    @GET("events")
    fun loadEvents(): Single<List<Actu>>


    @Headers(
        "X-AP-Key: uD4Muli8nO6nzkSlsNM3d1Pm",
        "X-AP-DeviceUID: trial",
        "Accept: application/json"
    )

    @FormUrlEncoded
    @POST("authentication/register")
    fun signUp(@Field("name") name :String,
               @Field("email") mail :String,
               @Field("phone") phone : String,
               @Field("picture") picture : String) : Single<RootObject>

}

