/*
package com.ly.baselibrary;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

*/
/**
 * Created by Administrator on 2017/5/20.
 *//*


public class MyViewHolder extends BaseViewHolder {

    public MyViewHolder(View view) {
        super(view);
    }


    public MyViewHolder setFrescoImage(@IdRes int viewId, String url, @Nullable String headUrl) {
        SimpleDraweeView view = getView(viewId);
        if (headUrl != null) {
            view.setImageURI(headUrl + url);
        } else {
            view.setImageURI(url);
        }
        return this;
    }

    public MyViewHolder setFrescoImageCircle(@IdRes int viewId, String url, @Nullable String headUrl) {
        SimpleDraweeView view = getView(viewId);
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        view.getHierarchy().setRoundingParams(roundingParams);
        if (headUrl != null) {
            view.setImageURI(headUrl + url);
        } else {
            view.setImageURI(url);
        }
        return this;
    }

    public MyViewHolder setViewVisible(@IdRes int viewId, boolean visible) {
        getView(viewId).setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }


}
*/
