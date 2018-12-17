package com.sample.actuproject.ui.presenter

import com.sample.actuproject.ActuApplication
import com.sample.actuproject.data.model.Success
import com.sample.actuproject.domain.usecase.SignUpUseCase
import com.sample.actuproject.ui.view.SignUpView
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SignUpPresenter(val signUpView: SignUpView){

    private val apiService = ActuApplication.getApiMangaService()

    fun signUp(name : String, mail : String, telephone : String){
        SignUpUseCase(apiService, name, mail, telephone).execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :  SingleObserver<Success>{
                override fun onSuccess(response: Success) {
                    signUpView.displayResult(response)
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    signUpView.showError(e.message!!)
                }
            })
    }


}