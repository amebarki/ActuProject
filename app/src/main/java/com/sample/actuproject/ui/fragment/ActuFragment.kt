package com.sample.actuproject.ui.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sample.actuproject.R
import com.sample.actuproject.data.model.Actu
import com.sample.actuproject.data.navigator.Navigator
import com.sample.actuproject.ui.adapter.ActuAdapter
import com.sample.actuproject.ui.presenter.ActuPresenter
import com.sample.actuproject.ui.view.ActuView
import kotlinx.android.synthetic.main.fragment_actu.*


class ActuFragment : Fragment(), ActuView {


    private lateinit var actuPresenter: ActuPresenter
    private lateinit var actuAdapter: ActuAdapter

    //region [** VIEW METHODS **]
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        actuPresenter = Navigator.instance().initActuPresenter(this)
        return inflater.inflate(R.layout.fragment_actu, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actuPresenter.loadEvents()
    }
    //endregion


    //region [** INTERFACE METHODS **]
    @SuppressLint("WrongConstant")
    override fun displayActus(actus: List<Actu>) {

        actuAdapter = ActuAdapter(
            actus,
            View.INVISIBLE
        ) { actuTitle: String, position: Int, isChecked: Boolean -> actuItemClicked(actuTitle, position, isChecked) }
        actu_recycler_view.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            activity!!.applicationContext,
            androidx.recyclerview.widget.LinearLayoutManager.VERTICAL,
            false
        )
        actu_recycler_view.adapter = actuAdapter

    }

    //endregion


    //region [** ITEMS METHODS **]

    private fun actuItemClicked(actuTitle: String, position: Int, isChecked: Boolean) {

    }

    //endregion


}
