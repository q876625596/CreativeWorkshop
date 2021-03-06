package com.ly.loginandregister.login

import com.ly.baselibrary.mvp.BasePresenter
import com.ly.baselibrary.mvp.BaseView

class LoginContract {
    interface View : BaseView

    interface Presenter : BasePresenter<View>
}
