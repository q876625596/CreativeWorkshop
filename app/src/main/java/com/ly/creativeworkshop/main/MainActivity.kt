package com.ly.creativeworkshop.main

import android.view.View
import com.ly.baselibrary.mvp.MVPBaseActivity

class MainActivity : MVPBaseActivity<MainContract.View, MainPresenter, MainViewModel>(),
    MainContract.View {

    override fun click(view: View) {

    }

    override fun initView() {

    }

    override fun setListener() {

    }

    override fun initData() {

    }
}