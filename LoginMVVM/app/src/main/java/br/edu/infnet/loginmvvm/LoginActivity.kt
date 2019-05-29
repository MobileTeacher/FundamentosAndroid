package br.edu.infnet.loginmvvm

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = LoginViewModel()

        setupListeners()
        subscribe()
    }

    private fun setupListeners(){
        login_button.setOnClickListener {
            val userEmail = email_edittext.text.toString()
            val userPassword = password_edittext.text.toString()
            loginViewModel.loginWithEmailAndPassword(
                                userEmail,
                                userPassword)
        }

        signup_textview.setOnClickListener {

        }
    }

    private fun subscribe(){
        loginViewModel.warningMessage.observe(this,
                Observer {message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })

        loginViewModel.isCheckingLogin.observe(this,
                Observer { isChecking->

                    if (isChecking == true){
                        Log.d("LOGINACTIVITY", "$isChecking")
                        progressbar.visibility = View.VISIBLE
                    } else {
                        progressbar.visibility = View.INVISIBLE
                    }
                })

        loginViewModel.userName.observe(this,
                Observer {name->
            if (name != null){
                user_textview.text = "Não é $name?"
                user_textview.visibility = View.VISIBLE
            } else {
                user_textview.visibility = View.INVISIBLE
            }

        })
    }


}
