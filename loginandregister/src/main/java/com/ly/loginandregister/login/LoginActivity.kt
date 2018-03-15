package com.ly.loginandregister.login


import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import android.view.animation.*
import com.chenenyu.router.annotation.Route
import com.ly.bezier.AnimationUtils
import com.ly.loginandregister.R
import com.ly.loginandregister.mvp.MVPBaseActivity
import kotlinx.android.synthetic.main.activity_login.*


@Route("login")
class LoginActivity : MVPBaseActivity<LoginContract.View, LoginPresenter, LoginViewModel>(),
    LoginContract.View {
    override fun click(view: View?) {
        when (view!!.id) {
        /* login.id -> show(false)
         register.id -> show(true)*/
        }
    }

    override fun initView() {
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        hideAnim(false)
    }

    override fun setListener() {
        login.setOnClickListener(this)
        register.setOnClickListener(this)
    }

    override fun initData() {

    }

    private fun hideAnim(isHideSun: Boolean) {
        if (isHideSun) {
            rotationAnim(viewRotation, -15f)
        } else {
            rotationAnim(viewRotation, 15f)
        }
        hideScaleAnim(if (isHideSun) sun else moon, object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                if (isHideSun) {
                    sun.visibility = View.GONE
                    cloud_1.visibility = View.GONE
                    cloud_2.visibility = View.GONE
                    cloud_3.visibility = View.GONE
                } else {
                    moon.visibility = View.GONE
                    star_1.visibility = View.GONE
                    star_2.visibility = View.GONE
                    star_3.visibility = View.GONE
                }
                showAnim(!isHideSun)
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
        hideScaleAnim(if (isHideSun) cloud_1 else star_1, null)
        hideScaleAnim(if (isHideSun) cloud_1 else star_2, null)
        hideScaleAnim(if (isHideSun) cloud_1 else star_3, null)
        hideScaleAnim(if (isHideSun) login else register, null)
    }

    private fun showAnim(isShowSun: Boolean) {
        showScaleAnim(if (isShowSun) login else register, null)
        showScaleAnim(if (isShowSun) cloud_1 else star_1, null)
        showScaleAnim(if (isShowSun) cloud_2 else star_2, null)
        showScaleAnim(if (isShowSun) cloud_3 else star_3, null)
        showScaleAnim(if (isShowSun) sun else moon, object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                getSunRotation(if (isShowSun) sun else moon, if (isShowSun) 360f else 60f)
                if (isShowSun) {
                    cloudTransAnim(cloud_1)
                    cloudTransAnim(cloud_2)
                    cloudTransAnim(cloud_3)
                } else {
                    starScaleAnim(star_1)
                    starScaleAnim(star_2)
                    starScaleAnim(star_3)
                }
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
    }


    //放大显示动画，带回弹
    private fun showScaleAnim(view: View, listener: Animator.AnimatorListener?) {
        view.clearAnimation()
        view.visibility = View.VISIBLE
        val scaleBean = AnimationUtils.ScaleBean(0f, 1f, 0f, 1f, 0.5f, 0.5f)
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
        animator.duration = 1000L
        animator.interpolator = OvershootInterpolator()
        if (listener != null) {
            animator.addListener(listener)
        }
        animator.start()
    }

    //缩小隐藏动画，带前摇
    private fun hideScaleAnim(view: View, listener: Animator.AnimatorListener?) {
        view.clearAnimation()
        val scaleBean = AnimationUtils.ScaleBean(1f, 0f, 1f, 0f, 0.5f, 0.5f)
        val scaleX = PropertyValuesHolder.ofFloat(
            "scaleX",
            scaleBean.startX, scaleBean.endX
        )
        val scaleY = PropertyValuesHolder.ofFloat(
            "scaleY",
            scaleBean.startY, scaleBean.endY
        )
        view.pivotX = scaleBean.pivotX
        view.pivotY = scaleBean.pivotY
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY)
        animator.duration = 1000L
        animator.interpolator = AnticipateInterpolator()
        if (listener != null) {
            animator.addListener(listener)
        }
        animator.start()
    }

    //渐变色动画
    private fun alphaAnim(view: View, alpha: Float) {
        view.clearAnimation()
        val alphaPro = PropertyValuesHolder.ofFloat("alpha", alpha)
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, alphaPro)
        animator.duration = 1000L
        animator.start()
    }

    //下方白块旋转动画
    private fun rotationAnim(view: View, end: Float) {
        view.clearAnimation()
        val rotatePro = PropertyValuesHolder.ofFloat(
            "rotation",
            view.rotation, end
        )
        view.pivotX = 0.5f * view.width
        view.pivotY = 0f
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, rotatePro)
        animator.duration = 1000L
        animator.start()
    }


    //云朵移动动画
    private fun cloudTransAnim(view: View) {
        view.clearAnimation()
        val translationX = PropertyValuesHolder.ofFloat(
            "translationX",
            0f, 0.6f
        )
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, translationX)
        animator.duration = 1000L
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
    }

    //星星重复缩放动画
    private fun starScaleAnim(view: View) {
        view.clearAnimation()
        val scaleBean = AnimationUtils.ScaleBean(1f, 1.3f, 1f, 1.3f, 0.5f, 0.5f)
        val scaleX = PropertyValuesHolder.ofFloat(
            "scaleX",
            scaleBean.startX, scaleBean.endX
        )
        val scaleY = PropertyValuesHolder.ofFloat(
            "scaleY",
            scaleBean.startY, scaleBean.endY
        )
        view.pivotX = scaleBean.pivotX
        view.pivotY = scaleBean.pivotY
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
    }

    private fun getSunRotation(view: View, rotate: Float) {
        view.clearAnimation()
        val rotateAnimation = RotateAnimation(
            0f, rotate,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
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
        view.startAnimation(rotateAnimation)
    }

    //太阳和月亮的旋转动画
    private fun sunAndMoonRunAnim(view: View, rotate: Float) {
        view.clearAnimation()
        val rotatePro = PropertyValuesHolder.ofFloat(
            "rotation",
            0f, rotate
        )
        view.pivotX = 0.5f
        view.pivotY = 0.5f
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, rotatePro)
        animator.duration = 1000L
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

    }
}
