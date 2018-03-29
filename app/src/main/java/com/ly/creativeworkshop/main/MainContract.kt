package com.ly.creativeworkshop.main

import com.ly.baselibrary.mvp.BasePresenter
import com.ly.baselibrary.mvp.BaseView


class MainContract {
    interface View : BaseView

    interface Presenter : BasePresenter<View>
}