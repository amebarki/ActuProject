package com.sample.actuproject.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.sample.actuproject.R
import com.sample.actuproject.data.model.Success
import com.sample.actuproject.data.navigator.Navigator
import com.sample.actuproject.ui.presenter.SignUpPresenter
import com.sample.actuproject.ui.view.SignUpView
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment(), SignUpView, View.OnClickListener {


    private lateinit var signupPresenter: SignUpPresenter

    //region [** VIEW METHODS **]
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        signupPresenter = Navigator.instance().initSignUpPresenter(this)

        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signupButton.setOnClickListener(this)
    }
    //endregion


    override fun displayResult(response: Success) {
        Toast.makeText(activity!!.applicationContext,response.message,Toast.LENGTH_LONG).show()
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signupButton -> {
                signupPresenter.signUp(
                    nameEditText.text.toString(),
                    mailEditText.text.toString(),
                    telephoneEditText.text.toString()
                )
            }

            else -> {
            }
        }
    }


}
