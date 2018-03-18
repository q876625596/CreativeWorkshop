package com.ly.loginandregister.login


import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.arch.lifecycle.ViewModelProviders
import android.util.Log
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

    private var sunAnimator: ObjectAnimator? = null
    private var cloud1Animator: ObjectAnimator? = null
    private var cloud2Animator: ObjectAnimator? = null
    private var cloud3Animator: ObjectAnimator? = null
    private var moonAnimator: ObjectAnimator? = null
    private var star1Animator: ObjectAnimator? = null
    private var star2Animator: ObjectAnimator? = null
    private var star3Animator: ObjectAnimator? = null

    override fun click(view: View?) {
        when (view!!.id) {
            toRegisterCard.id -> hideAnim(true)
            toLoginCard.id -> hideAnim(false)
        }
    }

    override fun initView() {
        setFixScreen()
        setContentView(R.layout.activity_login)
        //LoginAnko().setContentView(this)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        firstShow()
    }

    override fun setListener() {
        toRegisterCard.setOnClickListener(this)
        toLoginCard.setOnClickListener(this)
    }

    override fun initData() {

    }

    private fun firstShow() {
        bottomViewTransAnim(bottomView, object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                showAnim(true)
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
        bottomViewTransAnim(rotateView, null)
    }

    private fun hideAnim(isHideSun: Boolean) {
        if (isHideSun) {
            rotationAnim(rotateView, -15f)
            alphaAnim(foregroundView, 0f)
            alphaAnim(leftForeView, 0f)
            alphaAnim(rightForeView, 0f)
            if (sunAnimator != null) {
                sunAnimator!!.pause()
                cloud1Animator!!.pause()
                cloud2Animator!!.pause()
                cloud3Animator!!.pause()
            }
        } else {
            rotationAnim(rotateView, 15f)
            alphaAnim(foregroundView, 1f)
            alphaAnim(leftForeView, 1f)
            alphaAnim(rightForeView, 1f)
            if (moonAnimator != null) {
                moonAnimator!!.pause()
                star1Animator!!.pause()
                star2Animator!!.pause()
                star3Animator!!.pause()
            }
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
        hideScaleAnim(if (isHideSun) cloud_2 else star_2, null)
        hideScaleAnim(if (isHideSun) cloud_3 else star_3, null)
        if (isHideSun) {
            toRegisterCard.isClickable = false
        } else {
            toLoginCard.isClickable = false
        }
        hideScaleAnim(if (isHideSun) toRegisterCard else toLoginCard, null)
    }

    private fun showAnim(isShowSun: Boolean) {
        showScaleAnim(if (isShowSun) toRegisterCard else toLoginCard, null, null, null)
        if (isShowSun) {
            toRegisterCard.isClickable = true
        } else {
            toLoginCard.isClickable = true
        }
        showScaleAnim(
            if (isShowSun) cloud_1 else star_1, null,
            when {
                isShowSun -> null
                star1Animator != null -> star1Animator!!.getAnimatedValue(
                    "scaleX"
                ) as Float
                else -> null
            },
            when {
                isShowSun -> null
                star1Animator != null -> star1Animator!!.getAnimatedValue(
                    "scaleY"
                ) as Float
                else -> null
            }
        )
        showScaleAnim(
            if (isShowSun) cloud_2 else star_2, null,
            when {
                isShowSun -> null
                star2Animator != null -> star2Animator!!.getAnimatedValue(
                    "scaleX"
                ) as Float
                else -> null
            },
            when {
                isShowSun -> null
                star2Animator != null -> star2Animator!!.getAnimatedValue(
                    "scaleY"
                ) as Float
                else -> null
            }
        )
        showScaleAnim(
            if (isShowSun) cloud_3 else star_3, null,
            when {
                isShowSun -> null
                star3Animator != null -> star3Animator!!.getAnimatedValue(
                    "scaleX"
                ) as Float
                else -> null
            },
            when {
                isShowSun -> null
                star3Animator != null -> star3Animator!!.getAnimatedValue(
                    "scaleY"
                ) as Float
                else -> null
            }
        )
        showScaleAnim(
            if (isShowSun) sun else moon,
            object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    if (isShowSun) {
                        if (sunAnimator == null) {
                            sunAnimator = sunAndMoonRunAnim(sun, 360f)
                            cloud1Animator = cloudTransAnim(cloud_1)
                            cloud2Animator = cloudTransAnim(cloud_2)
                            cloud3Animator = cloudTransAnim(cloud_3)
                        } else {
                            sunAnimator!!.resume()
                            cloud1Animator!!.resume()
                            cloud2Animator!!.resume()
                            cloud3Animator!!.resume()
                        }
                    } else {
                        if (moonAnimator == null) {
                            moonAnimator = sunAndMoonRunAnim(moon, -30f)
                            star1Animator = starScaleAnim(star_1)
                            star2Animator = starScaleAnim(star_2)
                            star3Animator = starScaleAnim(star_3)
                        } else {
                            moonAnimator!!.resume()
                            star1Animator!!.resume()
                            star2Animator!!.resume()
                            star3Animator!!.resume()
                        }
                    }
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }
            }, null, null
        )
    }


    //放大显示动画，带回弹
    private fun showScaleAnim(
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
    private fun hideScaleAnim(view: View, listener: Animator.AnimatorListener?) {
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
    private fun alphaAnim(view: View, alpha: Float) {
        val alphaPro = PropertyValuesHolder.ofFloat("alpha", view.alpha, alpha)
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, alphaPro)
        animator.duration = 1000L
        animator.start()
    }

    //下方白块旋转动画
    private fun rotationAnim(view: View, end: Float) {
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

    private fun bottomViewTransAnim(view: View, listener: Animator.AnimatorListener?) {
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
    private fun cloudTransAnim(view: View): ObjectAnimator {
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
    private fun starScaleAnim(view: View): ObjectAnimator {
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
    private fun sunAndMoonRunAnim(view: View, rotate: Float): ObjectAnimator {
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
