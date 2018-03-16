package com.ly.loginandregister.login

import android.support.constraint.ConstraintLayout
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.ly.loginandregister.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import org.jetbrains.anko.constraint.layout.constraintLayout

/**
 * Created by ly on 2018/3/16.
 */
class LoginAnko : AnkoComponent<LoginActivity> {

    companion object {
        const val foregroundView = 1
        const val topLayout = 2
        const val bottomView = 3
        const val rotateView = 4
        const val leftBackView = 5
        const val rightBackView = 6
        const val leftForeView = 7
        const val rightForeView = 8
        const val loginCard = 9
        const val registerCard = 10
        const val sun = 11
        const val cloud_1 = 12
        const val cloud_2 = 13
        const val cloud_3 = 14
        const val moon = 15
        const val star_1 = 16
        const val star_2 = 17
        const val star_3 = 18
    }

    override fun createView(ui: AnkoContext<LoginActivity>) = with(ui) {
        constraintLayout {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            backgroundColorResource = R.color.nightBlack
            view {
                id = foregroundView
            }.lparams(0, 0) {
                backgroundColorResource = R.color.morningBlue
                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            }
            constraintLayout {
                id = topLayout
                imageView(R.drawable.ic_sun) {
                    id = sun
                }.lparams(dip(100), dip(100)) {
                    translationZ = 5f
                    visibility = View.INVISIBLE
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    horizontalBias = 0.1f
                }
                imageView(R.drawable.ic_cloud_72) {
                    id = cloud_1
                }.lparams(dip(33), dip(24)) {
                    translationZ = 5f
                    visibility = View.INVISIBLE
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    horizontalBias = 0.45f
                    verticalBias = 0.4f
                }
                imageView(R.drawable.ic_cloud_72) {
                    id = cloud_2
                }.lparams(dip(44), dip(32)) {
                    translationZ = 5f
                    visibility = View.INVISIBLE
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    horizontalBias = 0.62f
                    verticalBias = 0.1f
                }
                imageView(R.drawable.ic_cloud_72) {
                    id = cloud_3
                }.lparams(dip(55), dip(40)) {
                    translationZ = 5f
                    visibility = View.INVISIBLE
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    horizontalBias = 0.87f
                    verticalBias = 0.5f
                }
                imageView(R.drawable.ic_moon) {
                    id = moon
                }.lparams(dip(100), dip(100)) {
                    translationZ = 5f
                    visibility = View.INVISIBLE
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    horizontalBias = 0.9f
                }
                imageView(R.drawable.ic_star) {
                    id = star_1
                }.lparams(dip(33), dip(33)) {
                    translationZ = 5f
                    visibility = View.INVISIBLE
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    horizontalBias = 0.55f
                    verticalBias = 0.4f
                }
                imageView(R.drawable.ic_star) {
                    id = star_2
                }.lparams(dip(44), dip(44)) {
                    translationZ = 5f
                    visibility = View.INVISIBLE
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    horizontalBias = 0.38f
                    verticalBias = 0.1f
                }
                imageView(R.drawable.ic_star) {
                    id = star_3
                }.lparams(dip(33), dip(33)) {
                    translationZ = 5f
                    visibility = View.INVISIBLE
                    startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                    topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                    bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                    horizontalBias = 0.13f
                    verticalBias = 0.5f
                }
            }.lparams(0, 0) {
                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToTop = bottomView
                verticalWeight = 2f
            }
            view {
                id = bottomView
            }.lparams(0, 0) {
                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                topToBottom = topLayout
                verticalWeight = 3f
                backgroundColorResource = R.color.white
            }
            view {
                id = rotateView
            }.lparams(0, dip(150)) {
                backgroundColorResource = R.color.white
                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
                topToTop = bottomView
                bottomToTop = bottomView
                scaleX = 2f
                rotation = 0f
            }
            view {
                id = leftBackView
            }.lparams(dip(10), 0) {
                backgroundColorResource = R.color.nightBlack
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            }
            view {
                id = rightBackView
            }.lparams(dip(10), 0) {
                backgroundColorResource = R.color.nightBlack
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            }
            view {
                id = leftForeView
            }.lparams(dip(10), 0) {
                backgroundColorResource = R.color.morningBlue
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
            }
            view {
                id = rightForeView
            }.lparams(dip(10), 0) {
                backgroundColorResource = R.color.morningBlue
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            }
            cardView {
                id = loginCard
                textView("登录") {
                    textColorResource = R.color.black
                    gravity = Gravity.CENTER
                }.lparams(wrapContent, wrapContent) {

                }
            }.lparams(dip(60), dip(60)) {
                backgroundColorResource = R.color.white
                topToTop = rotateView
                endToEnd = rotateView
                marginEnd = dip(20)
            }
            cardView {
                id = registerCard
                textView("注册") {
                    textColorResource = R.color.black
                    gravity = Gravity.CENTER
                }.lparams(wrapContent, wrapContent) {
                }
            }.lparams(dip(60), dip(60)) {
                backgroundColorResource = R.color.white
                topToTop = rotateView
                startToStart = rotateView
                marginStart = dip(20)
            }
        }
    }
}