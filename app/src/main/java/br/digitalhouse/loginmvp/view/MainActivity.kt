package br.digitalhouse.loginmvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.digitalhouse.loginmvp.R
import br.digitalhouse.loginmvp.model.LoginAuth
import br.digitalhouse.loginmvp.presenter.LoginContract
import br.digitalhouse.loginmvp.presenter.LoginPresenter

class MainActivity : AppCompatActivity(), LoginContract.View {

    override lateinit var presenter: LoginPresenter

    lateinit var loginInput : EditText
    lateinit var passwordInput : EditText
    lateinit var btnLogin : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = LoginPresenter(this)
        presenter.start()

        btnLogin.setOnClickListener {
            presenter.isLoginValid(loginInput.text.toString(),
            passwordInput.text.toString())
        }
    }

    override fun showError() {
       Toast.makeText(this,"Usuário ou senha incorreta", Toast.LENGTH_LONG).show()
    }

    override fun startHomeActivity() {
     var intent =  Intent(this, HomeActivity :: class.java)
      startActivity(intent)
    }

    override fun bindView() {
       loginInput = findViewById(R.id.txtUser)
       passwordInput = findViewById(R.id.txtPass)
       btnLogin = findViewById(R.id.btnLogin)

    }
}