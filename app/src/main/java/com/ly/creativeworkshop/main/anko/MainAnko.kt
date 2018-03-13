package com.ly.creativeworkshop.main.anko

import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ly.baselibrary.SystemUtils
import com.ly.creativeworkshop.R
import com.ly.creativeworkshop.main.activity.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

/**
 * Created by Administrator on 2018/3/5.
 */
class MainAnko : AnkoComponent<MainActivity> {
    companion object {
        const val IMAGE_VIEW = 1
        const val LOGIN_BTN = 2
        const val REGISTER_BTN = 3
    }

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        constraintLayout {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            imageView {
                id = IMAGE_VIEW
                val wh = SystemUtils.getScreenWidthAndHeight(ctx as MainActivity)
                if (wh[1] / (wh[0] * 0.1) > 16 / 9.0) {
                    Glide.with(this).load(R.drawable.creative_2160)
                            .into(this)
                } else {
                    Glide.with(this).load(R.drawable.creative_1920)
                            .into(this)
                }
            }.lparams(0, 0) {
                marginStart = dip(10)
                marginEnd = dip(5)
                leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            }
            button("登录") {
                id = LOGIN_BTN
                textColorResource = R.color.white
                backgroundResource = R.drawable.main_login_btn_press
                gravity = Gravity.CENTER
            }.lparams(0, wrapContent) {
                marginStart = dip(5)
                marginEnd = dip(10)
                startToStart = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                verticalBias = 0.98f
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                endToStart = REGISTER_BTN
            }
            button("注册") {
                backgroundResource = R.drawable.main_login_btn_press
                textColorResource = R.color.white
                id = REGISTER_BTN
                gravity = Gravity.CENTER
            }.lparams(0, wrapContent) {
                startToEnd = LOGIN_BTN
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                verticalBias = 0.98f
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
                endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            }
        }
    }
}