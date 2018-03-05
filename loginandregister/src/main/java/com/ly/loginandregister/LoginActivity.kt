package com.ly.loginandregister

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chenenyu.router.annotation.Route


@Route("login")
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
