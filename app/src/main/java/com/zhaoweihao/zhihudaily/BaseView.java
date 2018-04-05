package com.zhaoweihao.zhihudaily;

import android.view.View;

/**
 * Created by zhao weihao on 2018/4/5.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void initViews(View view);

}
