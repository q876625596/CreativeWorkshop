package com.ly.baselibrary;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by kumi on 2017/3/16 0016.
 */

public abstract class BaseFragment<A extends FragmentActivity, M extends ViewModel> extends RxFragment implements View.OnClickListener {

    /*
    * 该fragment的Activity
    */
    protected A mActivity;

    /*
    * 该fragment的ViewModel
    */
    public M viewModel;

    /**
     * 是否对用户可见
     */
    protected boolean shouldVisible;

    /**
     * 是否初始化加载完成
     * 当执行完onCreateView，需要手动设置该属性为true
     */
    protected boolean initCompleted;

    /*
    * 是否已经执行过一次懒加载，如果只执行一次懒加载，就在执行完onLazyLoad()之后设为true，
    * 如果需要fragment每次显示都懒加载数据，那么永远设置为false
    *
    */
    protected boolean shouldLazy;

    /**
     * 初始化
     * 执行顺序：3
     * 执行次数：1
     */
    /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //初始化根view
        dataBinding = DataBindingUtil.inflate(inflater, setLayoutResourceId(), container, false);
        //初始化view
        initView();
        //设置监听
        setListener();
        //获取activity传来的数据，如果没有则不实现该方法
        getData(getArguments());
        //初始化数据，如果需要懒加载，则可以不实现该方法
        initData();
        //初始化view之后将initComplete设置为true
        initCompleted = true;
        return dataBinding.getRoot();
    }*/

    /**
     * 贴附的activity
     * 执行顺序：1
     * 执行次数：每次显示时执行
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.shouldVisible = isVisibleToUser;
        if (isVisibleToUser) {
            onVisibleToUser();
        }
    }

    //懒加载数据,如果不需要则不实现onLazyLoad()
    protected void onVisibleToUser() {
        //如果已经初始化并且允许懒加载
        if (initCompleted && !shouldLazy) {
            onLazyLoad();
        }
    }

    /**
     * 绑定Activity
     * 执行顺序：2
     * 执行次数：1
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (A) context;
    }

    //避免用户重复点击，300ms内只允许触发控件一次
    private long lastTime = 0;

    private long clickLimit = 300L;

    public long getClickLimit() {
        return clickLimit;
    }

    public void setClickLimit(long clickLimit) {
        this.clickLimit = clickLimit;
    }

    /**
     * 限制一段时间内的多次点击（一秒内点击一次）
     *
     * @return 如果单次点击则返回true，反之false
     */
    protected synchronized boolean couldClick() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime < clickLimit) {
            return false;
        } else {
            lastTime = currentTime;
            return true;
        }
    }

    @Override
    public void onClick(View v) {
        //防止短时间内多次点击
        if (!couldClick()) {
            return;
        }
        click(v);
        //如需双击则继承时删除此方法的super
    }

    /**
     * 点击监听事件
     *
     * @param view 被监听的view
     */
    public abstract void click(View view);

    /**
     * 初始化，一些数据的绑定等
     */
    abstract protected void initView();

    /**
     * 为控件设置监听
     */
    abstract protected void setListener();


    /**
     * 懒加载数据,如果不需要则不实现该方法,主要用于重新进入界面时数据刷新
     */
    protected void onLazyLoad() {

    }
}
