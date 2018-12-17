package com.sample.actuproject.ui.presenter

import com.sample.actuproject.ActuApplication
import com.sample.actuproject.data.model.Actu
import com.sample.actuproject.domain.usecase.LoadEventsUseCase
import com.sample.actuproject.ui.view.ActuView
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ActuPresenter(val actuView: ActuView){

    private val apiService = ActuApplication.getApiMangaService()


    fun loadEvents() {
        LoadEventsUseCase(apiService).execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Actu>> {
                override fun onSuccess(actus: List<Actu>) {
                    actuView.displayActus(actus)
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    actuView.showError(e.message.toString())
                }
            })
    }

}