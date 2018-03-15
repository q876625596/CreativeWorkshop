package com.ly.loginandregister.mvp

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.os.Bundle
import android.util.Log

import com.ly.baselibrary.BaseActivity

import java.lang.reflect.ParameterizedType


abstract class MVPBaseActivity<in V : BaseView, T : BasePresenterImpl<V>, M : ViewModel> :
    BaseActivity<M>(), BaseView {
    var mPresenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("asas", "aaa")
        mPresenter = getInstance<T>(this, 1)
        Log.e("asas", "aaaa")
        mPresenter!!.attachView(this as V)
        initView()
        getData()
        setListener()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null)
            mPresenter!!.detachView()
    }

    override fun getContext(): Context? {
        return this
    }

    private fun <T> getInstance(o: Any, i: Int): T? {
        try {
            return ((o.javaClass
                .genericSuperclass as ParameterizedType)
                .actualTypeArguments[i] as Class<T>)
                .newInstance()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: ClassCastException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        return null
    }
}
