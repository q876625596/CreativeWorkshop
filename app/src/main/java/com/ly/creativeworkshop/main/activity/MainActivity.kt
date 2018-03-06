package com.ly.creativeworkshop.main.activity

import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.bumptech.glide.Glide
import com.chenenyu.router.Router
import com.ly.baselibrary.SystemUtils
import com.ly.creativeworkshop.R
import com.ly.creativeworkshop.mvp.MVPBaseActivity
import kotlinx.android.synthetic.main.main_activity_main.*

class MainActivity : MVPBaseActivity<MainContract.View, MainPresenter, MainViewModel>(),
    MainContract.View {

    override fun click(view: View) {

    }

    override fun initView() {
        setContentView(R.layout.main_activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        btn.setOnClickListener({
            Router.build("login").go(this)
        })
        val wh = SystemUtils.getScreenWidthAndHeight(this)
        if (wh[1] / wh[0] <= 16 / 9) {
            Glide.with(this).load(R.drawable.b1920)
                .into(image)
        } else {
            Glide.with(this).load(R.drawable.b2160)
                .into(image)
        }
    }

    override fun setListener() {

    }

    override fun initData() {

    }
}