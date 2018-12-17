package com.sample.actuproject.ui.view

import com.sample.actuproject.base.view.BaseView
import com.sample.actuproject.data.model.Success

interface SignUpView : BaseView {

    fun displayResult(response : Success)
}