package com.ly.creativeworkshop.launch

import com.ly.baselibrary.mvp.BasePresenter
import com.ly.baselibrary.mvp.BaseView


class LauncherContract {
    interface View : BaseView

    interface Presenter : BasePresenter<View>
}
