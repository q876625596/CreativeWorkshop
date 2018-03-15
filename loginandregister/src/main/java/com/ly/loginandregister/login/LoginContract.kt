package com.ly.loginandregister.login

import com.ly.loginandregister.mvp.BasePresenter
import com.ly.loginandregister.mvp.BaseView

class LoginContract {
    interface View : BaseView

    interface Presenter : BasePresenter<View>
}
