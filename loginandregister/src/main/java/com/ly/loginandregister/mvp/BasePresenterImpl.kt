package com.ly.loginandregister.mvp


open class BasePresenterImpl<in V : BaseView> : BasePresenter<V> {
    private var mView: V? = null
    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}
