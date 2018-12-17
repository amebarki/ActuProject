package com.sample.actuproject.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sample.actuproject.R
import com.sample.actuproject.data.navigator.Navigator
import com.sample.actuproject.ui.presenter.InfoPresenter
import com.sample.actuproject.ui.view.InfoView
import kotlinx.android.synthetic.main.fragment_info.*


class InfoFragment : Fragment(), InfoView {

    private lateinit var infoPresenter: InfoPresenter


    //region [** VIEW METHODS **]
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        infoPresenter = Navigator.instance().initInfoPresenter(this)
        return inflater.inflate(R.layout.fragment_info, container, false)
    }


    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webSettings = info_web_view.settings
        val extraHeaders = HashMap<String, String>()

        webSettings.javaScriptEnabled = true
        extraHeaders["X-AP-Key"] = "uD4Muli8nO6nzkSlsNM3d1Pm"
        extraHeaders["X-AP-DeviceUID"] = "trial"
        extraHeaders["Accept"] = "text/html"
        info_web_view.loadUrl("https://test-pgt-dev.apnl.ws/html",extraHeaders)

    }
    //endregion


    override fun displayPage() {
    }


}
