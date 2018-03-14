package com.ly.loginandregister

import android.animation.ObjectAnimator
import android.graphics.Path
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.*
import android.widget.ImageView
import com.chenenyu.router.annotation.Route
import kotlinx.android.synthetic.main.activity_login.*


@Route("login")
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        showLogin()

    }

    private fun showLogin() {
        sun.startAnimation(getShowLoginScale(sun, getSunRotation()))
        cloud_1.startAnimation(getShowLoginScale(cloud_1, getCloudTrans()))
        cloud_2.startAnimation(getShowLoginScale(cloud_2, getCloudTrans()))
        cloud_3.startAnimation(getShowLoginScale(cloud_3, getCloudTrans()))
        login.startAnimation(getShowLoginScale(null, null))
        viewRotation.startAnimation(getHideRegisterRotation())
    }

    private fun showRegister() {

    }

    private fun getSunRotation(): Animation {
        val rotateAnimation = RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.duration = 6000
        rotateAnimation.repeatCount = 10
        rotateAnimation.interpolator = AccelerateDecelerateInterpolator()
        rotateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
                animation!!.repeatCount = animation.repeatCount + 1
            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
        rotateAnimation.repeatMode = Animation.REVERSE
        return rotateAnimation
    }

    private fun getCloudTrans(): Animation {
        val translateAnimation = TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0.6f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f)
        translateAnimation.duration = 2000
        translateAnimation.repeatCount = 10
        translateAnimation.repeatMode = Animation.REVERSE
        translateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
                animation!!.repeatCount = animation.repeatCount + 1
            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
        return translateAnimation
    }

    private fun getHideLoginRotation(): RotateAnimation {
        val hideLoginRotation = RotateAnimation(0f, -15f - viewRotation.rotation,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0f)
        hideLoginRotation.duration = 1000
        hideLoginRotation.fillAfter = true
        return hideLoginRotation
    }

    private fun getHideRegisterRotation(): RotateAnimation {
        val hideRegisterRotation = RotateAnimation(0f, 15f - viewRotation.rotation,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0f)
        hideRegisterRotation.duration = 1000
        hideRegisterRotation.fillAfter = true
        return hideRegisterRotation
    }

    private fun getHideLoginScale(): ScaleAnimation {
        val hideLoginScale = ScaleAnimation(1f, 0f, 1f, 0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        hideLoginScale.duration = 1000
        return hideLoginScale
    }

    private fun getHideRegisterScale(): ScaleAnimation {
        val hideRegisterScale = ScaleAnimation(1f, 0f, 1f, 0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        hideRegisterScale.duration = 1000
        return hideRegisterScale
    }

    private fun getShowLoginScale(view: View?, secondAnimation: Animation?): ScaleAnimation {
        val showLoginScale = ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        showLoginScale.duration = 1000
        showLoginScale.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                view?.startAnimation(secondAnimation)
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
        return showLoginScale
    }

    private fun getShowRegisterScale(view: View?, secondAnimation: Animation?): ScaleAnimation {
        val showRegisterScale = ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        showRegisterScale.duration = 1000
        showRegisterScale.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                view?.startAnimation(secondAnimation)
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
        return showRegisterScale
    }

}
