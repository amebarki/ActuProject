package com.sample.actuproject.data.navigator

import com.sample.actuproject.ui.presenter.ActuPresenter
import com.sample.actuproject.ui.presenter.InfoPresenter
import com.sample.actuproject.ui.presenter.SignUpPresenter
import com.sample.actuproject.ui.view.ActuView
import com.sample.actuproject.ui.view.InfoView
import com.sample.actuproject.ui.view.SignUpView

object Navigator {
    private var instance: Navigator? = null

    init {
        instance = this
    }


    fun instance(): Navigator {

        return instance!!
    }

    fun init() {
    }



    fun initActuPresenter(view: ActuView): ActuPresenter {
        return ActuPresenter(view)
    }

    fun initInfoPresenter(view: InfoView): InfoPresenter {
        return InfoPresenter(view)
    }


    fun initSignUpPresenter(view: SignUpView): SignUpPresenter {
        return SignUpPresenter(view)
    }




}