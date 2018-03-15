package com.ly.creativeworkshop.mvp

import com.ly.loginandregister.mvp.BasePresenter
import com.ly.loginandregister.mvp.BaseView


open class BasePresenterImpl<in V : BaseView> : BasePresenter<V> {
    private var mView: V? = null
    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}
