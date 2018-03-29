package com.ly.loginandregister.login

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnticipateInterpolator
import android.view.animation.OvershootInterpolator
import com.ly.bezier.AnimationUtils

/**
 * Created by ly on 2018/3/15.
 */
class LoginViewModel : ViewModel() {


    //放大显示动画，带回弹
    fun showScaleAnim(
        view: View,
        listener: Animator.AnimatorListener?,
        oldX: Float?,
        oldY: Float?
    ) {
        view.visibility = View.VISIBLE
        val scaleBean = AnimationUtils.ScaleBean(
            0f,
            oldX ?: 1f,
            0f,
            oldY ?: 1f,
            0.5f,
            0.5f
        )
        val scaleX = PropertyValuesHolder.ofFloat(
            "scaleX",
            *floatArrayOf(scaleBean.startX, scaleBean.endX)
        )
        val scaleY = PropertyValuesHolder.ofFloat(
            "scaleY",
            *floatArrayOf(scaleBean.startY, scaleBean.endY)
        )
        view.pivotX = scaleBean.pivotX * view.width
        view.pivotY = scaleBean.pivotY * view.height
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY)
        animator.duration = 500L
        animator.interpolator = OvershootInterpolator()
        if (listener != null) {
            animator.addListener(listener)
        }
        animator.start()
    }

    //缩小隐藏动画，带前摇
    fun hideScaleAnim(view: View, listener: Animator.AnimatorListener?) {
        val scaleBean = AnimationUtils.ScaleBean(view.scaleX, 0f, view.scaleY, 0f, 0.5f, 0.5f)
        val scaleX = PropertyValuesHolder.ofFloat(
            "scaleX",
            scaleBean.startX, scaleBean.endX
        )
        val scaleY = PropertyValuesHolder.ofFloat(
            "scaleY",
            scaleBean.startY, scaleBean.endY
        )
        view.pivotX = scaleBean.pivotX * view.width
        view.pivotY = scaleBean.pivotY * view.height
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY)
        animator.duration = 500L
        animator.interpolator = AnticipateInterpolator()
        if (listener != null) {
            animator.addListener(listener)
        }
        animator.start()
    }

    //渐变色动画
    fun alphaAnim(view: View, alpha: Float) {
        val alphaPro = PropertyValuesHolder.ofFloat("alpha", view.alpha, alpha)
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, alphaPro)
        animator.duration = 1000L
        animator.start()
    }

    //下方白块旋转动画
    fun rotationAnim(view: View, end: Float) {
        val rotatePro = PropertyValuesHolder.ofFloat(
            "rotation",
            view.rotation, end
        )
        Log.e("sasa", view.width.toString())
        view.pivotX = 0.5f * view.width
        view.pivotY = 0f
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, rotatePro)
        animator.duration = 1000L
        animator.start()
    }

    fun bottomViewTransAnim(view: View, listener: Animator.AnimatorListener?) {
        val translationY = PropertyValuesHolder
            .ofFloat(
                "translationY",
                1080f,
                0f
            )
        Log.e("asd", view.height.toString())
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, translationY)
        animator.duration = 1000L
        animator.interpolator = OvershootInterpolator()
        if (listener != null) {
            animator.addListener(listener)
        }
        animator.start()
    }

    //云朵移动动画
    fun cloudTransAnim(view: View): ObjectAnimator {
        val translationX = PropertyValuesHolder.ofFloat(
            "translationX",
            view.translationY, -view.width * 0.5f
        )
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, translationX)
        animator.duration = 2000L
        animator.repeatCount = 10
        animator.repeatMode = ValueAnimator.REVERSE
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                animator.repeatCount++
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
                view.translationX = 0f
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
        animator.start()
        return animator
    }

    //星星重复缩放动画
    fun starScaleAnim(view: View): ObjectAnimator {
        val scaleBean = AnimationUtils.ScaleBean(1f, 1.3f, 1f, 1.3f, 0.5f, 0.5f)
        val scaleX = PropertyValuesHolder.ofFloat(
            "scaleX",
            scaleBean.startX, scaleBean.endX
        )
        val scaleY = PropertyValuesHolder.ofFloat(
            "scaleY",
            scaleBean.startY, scaleBean.endY
        )
        view.pivotX = scaleBean.pivotX * view.width
        view.pivotY = scaleBean.pivotY * view.width
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY)
        animator.duration = 1000L
        animator.repeatCount = 10
        animator.repeatMode = ValueAnimator.REVERSE
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                animator.repeatCount++
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
                view.scaleX = 1f
                view.scaleY = 1f
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
        animator.start()
        return animator
    }

    //太阳和月亮的旋转动画
    fun sunAndMoonRunAnim(view: View, rotate: Float): ObjectAnimator {
        val rotatePro = PropertyValuesHolder.ofFloat(
            "rotation",
            0f, rotate
        )
        view.pivotX = 0.5f * view.width
        view.pivotY = 0.5f * view.height
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, rotatePro)
        animator.duration = 6000L
        animator.repeatCount = 10
        animator.repeatMode = ValueAnimator.REVERSE
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                animator.repeatCount++
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
        animator.start()
        return animator
    }

}