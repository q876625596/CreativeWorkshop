package com.ly.creativeworkshop.mvp

import com.ly.loginandregister.mvp.BaseView

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

interface BasePresenter<in V : BaseView> {
    fun attachView(view: V)

    fun detachView()
}
