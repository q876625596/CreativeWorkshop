package com.ly.loginandregister.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by ly on 2018/3/15.
 */
class LoginViewModel : ViewModel() {
    //当前开始运行的动画，true为太阳和云朵，false为月亮和星星
    val currentRun = MutableLiveData<Boolean>()
    init {
        currentRun.value = true
    }


}