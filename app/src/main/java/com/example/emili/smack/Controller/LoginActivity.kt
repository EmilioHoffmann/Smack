package com.example.emili.smack.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.emili.smack.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginCreateUserButtonClicked(view: View){
        val createUserIntent = Intent(this, CreateUserActivity::class.java)
        startActivity(createUserIntent)
    }

    fun loginLoginButtonClicked(view: View){

    }
}
