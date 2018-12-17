package com.sample.actuproject.ui.view

import com.sample.actuproject.base.view.BaseView
import com.sample.actuproject.data.model.Actu

interface ActuView : BaseView {

    fun displayActus(actus: List<Actu>)
}