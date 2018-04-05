package com.zhaoweihao.zhihudaily.zhihudaily;

import com.zhaoweihao.zhihudaily.BasePresenter;
import com.zhaoweihao.zhihudaily.BaseView;
import com.zhaoweihao.zhihudaily.data.ZhihuDaily;

import java.util.ArrayList;

/**
 * Created by zhao weihao on 2018/4/5.
 */

public interface ZhihuDailyContract {

    interface View extends BaseView<Presenter> {

        void showResult(ArrayList<ZhihuDaily.Story> articleList);

        void startLoading();

        void stopLoading();

        void showLoadError();

    }

    interface Presenter extends BasePresenter {

        void requestArticles(Boolean forceRefresh);

        ArrayList<ZhihuDaily.Story> getArticles();

        void copyToClipboard(int position);

    }
}
