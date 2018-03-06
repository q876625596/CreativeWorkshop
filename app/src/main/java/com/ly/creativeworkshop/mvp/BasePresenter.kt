package com.ly.creativeworkshop.mvp

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

interface BasePresenter<in V : BaseView> {
    fun attachView(view: V)

    fun detachView()
}
