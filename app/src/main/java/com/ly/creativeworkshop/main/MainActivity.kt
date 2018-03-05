package com.ly.creativeworkshop.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chenenyu.router.Router
import com.ly.creativeworkshop.R
import kotlinx.android.synthetic.main.main_activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)
        btn.setOnClickListener({
            Router.build("login").go(this)
        })
    }
}
