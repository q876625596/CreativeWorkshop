package com.ly.creativeworkshop.main.anko

import android.support.constraint.ConstraintLayout
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
    }
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        constraintLayout {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            imageView {
                id = IMAGE_VIEW
                val wh = SystemUtils.getScreenWidthAndHeight(ctx as MainActivity)
                if (wh[1] / wh[0] <= 16 / 9) {
                    Glide.with(this).load(R.drawable.creative_1920)
                            .into(this)
                } else {
                    Glide.with(this).load(R.drawable.creative_2160)
                            .into(this)
                }
            }.lparams(0, 0){
                leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
                bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            }
            button("aasdsad")
        }
    }
}