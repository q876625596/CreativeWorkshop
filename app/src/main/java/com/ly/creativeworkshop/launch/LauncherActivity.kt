package com.ly.creativeworkshop.launch


import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.chenenyu.router.Router
import com.ly.baselibrary.mvp.MVPBaseActivity
import com.ly.creativeworkshop.R
import kotlinx.android.synthetic.main.main_activity_main.*


class LauncherActivity : MVPBaseActivity<LauncherContract.View, LauncherPresenter, LauncherViewModel>(), LauncherContract.View{
    override fun click(view: View?) {
    }

    override fun initView() {
        setFixScreen()
        setContentView(R.layout.main_activity_main)
        setTransparentStatusBar(false)
        viewModel = ViewModelProviders.of(this).get(LauncherViewModel::class.java)
        startBtn.setOnClickListener({
            Router.build("login").go(this)
        })
        /*val wh = SystemUtils.getScreenWidthAndHeight(this)
        if (wh[1] / wh[0].toDouble() <= 16.0 / 9) {
            Glide.with(this).load(R.drawable.creative_1920)
                    .into(image)
        } else {
            Glide.with(this).load(R.drawable.creative_2160)
                    .into(image)
        }*/
    }

    override fun setListener() {

    }

    override fun initData() {
    }

}

