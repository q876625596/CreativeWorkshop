package com.ly.creativeworkshop.main.activity

import com.ly.loginandregister.mvp.BasePresenter
import com.ly.loginandregister.mvp.BaseView

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class MainContract {
    interface View : BaseView

    interface Presenter : BasePresenter<View>
}