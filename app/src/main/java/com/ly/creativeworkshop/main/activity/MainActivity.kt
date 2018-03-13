package com.ly.creativeworkshop.main.activity

import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.ly.creativeworkshop.main.anko.MainAnko
import com.ly.creativeworkshop.mvp.MVPBaseActivity
import org.jetbrains.anko.setContentView

class MainActivity : MVPBaseActivity<MainContract.View, MainPresenter, MainViewModel>(),
        MainContract.View {

    override fun click(view: View) {

    }

    override fun initView() {
        setFixScreen()
        MainAnko().setContentView(this)
        //setContentView(R.layout.main_activity_main)
        setTransparentStatusBar(false)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        /*btn.setOnClickListener({
            Router.build("login").go(this)
        })*/
      /*  val wh = SystemUtils.getScreenWidthAndHeight(this)
        if (wh[1] / wh[0] <= 16 / 9) {
            Glide.with(this).load(R.drawable.creative_1920)
                    .into(find(MainAnko.IMAGE_VIEW))
        } else {
            Glide.with(this).load(R.drawable.creative_2160)
                    .into(find(MainAnko.IMAGE_VIEW))
        }*/
    }

    override fun setListener() {

    }

    override fun initData() {

    }
}