package com.ly.loginandregister.login


import android.animation.Animator
import android.animation.ObjectAnimator
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.chenenyu.router.annotation.Route
import com.ly.loginandregister.R
import com.ly.baselibrary.mvp.MVPBaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.register_layout.*


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
        when (view) {
            toRegister -> {
                hideAnim(true)
                if (registerLayout == null) {
                    registerViewStub.inflate()
                }
                viewModel.hideScaleAnim(loginLayout, object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(animation: Animator?) {
                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        loginLayout.visibility = View.INVISIBLE
                        registerLayout.visibility = View.VISIBLE
                        viewModel.showScaleAnim(registerLayout, null, null, null)
                    }

                    override fun onAnimationCancel(animation: Animator?) {
                    }

                    override fun onAnimationStart(animation: Animator?) {
                    }

                })

            }
            toLogin -> {
                hideAnim(false)
                viewModel.hideScaleAnim(registerLayout, object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(animation: Animator?) {
                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        registerLayout.visibility = View.INVISIBLE
                        loginLayout.visibility = View.VISIBLE
                        viewModel.showScaleAnim(loginLayout, null, null, null)
                    }

                    override fun onAnimationCancel(animation: Animator?) {
                    }

                    override fun onAnimationStart(animation: Animator?) {
                    }

                })
            }

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
        toRegister.setOnClickListener(this)
        registerViewStub.setOnInflateListener { _, _ ->
            toLogin.setOnClickListener(this@LoginActivity)
        }
    }

    override fun initData() {

    }

    override fun onResume() {
        super.onResume()
        if (loginCard.visibility == View.VISIBLE) {
            if (sunAnimator!!.isPaused) {
                sunAnimator?.resume()
                cloud1Animator?.resume()
                cloud2Animator?.resume()
                cloud3Animator?.resume()
            }
        }
        if (registerCard.visibility == View.VISIBLE) {
            if (moonAnimator!!.isPaused) {
                moonAnimator?.resume()
                star1Animator?.resume()
                star2Animator?.resume()
                star3Animator?.resume()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        if (sunAnimator == null) {
            return
        }
        sunAnimator?.pause()
        cloud1Animator?.pause()
        cloud2Animator?.pause()
        cloud3Animator?.pause()
        moonAnimator?.pause()
        star1Animator?.pause()
        star2Animator?.pause()
        star3Animator?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (sunAnimator == null) {
            return
        }
        sunAnimator?.end()
        cloud1Animator?.end()
        cloud2Animator?.end()
        cloud3Animator?.end()
        moonAnimator?.end()
        star1Animator?.end()
        star2Animator?.end()
        star3Animator?.end()
    }

    //第一次显示动画
    private fun firstShow() {
        viewModel.bottomViewTransAnim(bottomView, object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                showAnim(true)
                loginLayout.visibility = View.VISIBLE
                viewModel.showScaleAnim(loginLayout, null, null, null)

            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
        viewModel.bottomViewTransAnim(rotateView, null)
    }

    //隐藏动画
    private fun hideAnim(isHideSun: Boolean) {
        if (isHideSun) {
            //旋转上方白块
            viewModel.rotationAnim(rotateView, -15f)
            //设置前景view为透明
            viewModel.alphaAnim(foregroundView, 0f)
            viewModel.alphaAnim(leftForeView, 0f)
            viewModel.alphaAnim(rightForeView, 0f)
            //暂停太阳和云朵的动画
            if (sunAnimator != null) {
                sunAnimator!!.pause()
                cloud1Animator!!.pause()
                cloud2Animator!!.pause()
                cloud3Animator!!.pause()
            }
        } else {
            viewModel.rotationAnim(rotateView, 15f)
            viewModel.alphaAnim(foregroundView, 1f)
            viewModel.alphaAnim(leftForeView, 1f)
            viewModel.alphaAnim(rightForeView, 1f)
            //暂停月亮和星星的动画
            if (moonAnimator != null) {
                moonAnimator!!.pause()
                star1Animator!!.pause()
                star2Animator!!.pause()
                star3Animator!!.pause()
            }
        }
        //隐藏太阳/月亮动画监听
        viewModel.hideScaleAnim(if (isHideSun) sun else moon, object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                //当隐藏动画完成
                if (isHideSun) {
                    //隐藏太阳和云朵
                    sun.visibility = View.GONE
                    cloud_1.visibility = View.GONE
                    cloud_2.visibility = View.GONE
                    cloud_3.visibility = View.GONE
                } else {
                    //隐藏月亮和星星
                    moon.visibility = View.GONE
                    star_1.visibility = View.GONE
                    star_2.visibility = View.GONE
                    star_3.visibility = View.GONE
                }
                //调用显示动画
                showAnim(!isHideSun)
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })
        //隐藏云朵/星星动画
        viewModel.hideScaleAnim(if (isHideSun) cloud_1 else star_1, null)
        viewModel.hideScaleAnim(if (isHideSun) cloud_2 else star_2, null)
        viewModel.hideScaleAnim(if (isHideSun) cloud_3 else star_3, null)
        //隐藏卡片动画
        viewModel.hideScaleAnim(if (isHideSun) loginCard else registerCard, null)
    }

    //显示动画
    private fun showAnim(isShowSun: Boolean) {
        //显示卡片动画
        viewModel.showScaleAnim(if (isShowSun) loginCard else registerCard, null, null, null)
        //显示云朵/星星动画
        viewModel.showScaleAnim(
            if (isShowSun) cloud_1 else star_1, null,
            when {
            //如果是显示太阳，那么为null
                isShowSun -> null
            // 因为星星为scale动画
            // 所以如果星星动画不为空，那么获取星星动画当前的scale值，从当前scale开始动画
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
        viewModel.showScaleAnim(
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
        viewModel.showScaleAnim(
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
        //显示太阳/月亮动画
        viewModel.showScaleAnim(
            if (isShowSun) sun else moon,
            object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    //动画完成后
                    if (isShowSun) {
                        //开始太阳和云朵的动画
                        if (sunAnimator == null) {
                            sunAnimator = viewModel.sunAndMoonRunAnim(sun, 360f)
                            cloud1Animator = viewModel.cloudTransAnim(cloud_1)
                            cloud2Animator = viewModel.cloudTransAnim(cloud_2)
                            cloud3Animator = viewModel.cloudTransAnim(cloud_3)
                        } else {
                            sunAnimator!!.resume()
                            cloud1Animator!!.resume()
                            cloud2Animator!!.resume()
                            cloud3Animator!!.resume()
                        }
                    } else {
                        //开始月亮和星星的动画
                        if (moonAnimator == null) {
                            moonAnimator = viewModel.sunAndMoonRunAnim(moon, -30f)
                            star1Animator = viewModel.starScaleAnim(star_1)
                            star2Animator = viewModel.starScaleAnim(star_2)
                            star3Animator = viewModel.starScaleAnim(star_3)
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

}
