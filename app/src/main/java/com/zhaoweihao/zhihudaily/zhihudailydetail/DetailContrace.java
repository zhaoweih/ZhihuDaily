package com.zhaoweihao.zhihudaily.zhihudailydetail;

import com.zhaoweihao.zhihudaily.BasePresenter;
import com.zhaoweihao.zhihudaily.BaseView;
import com.zhaoweihao.zhihudaily.data.Detail;

/**
 * Created by por on 2018/4/5.
 */

public interface DetailContrace {

    interface View extends BaseView<Presenter> {

        void showResult(Detail detail);

        void startLoading();

        void stopLoading();

        void showLoadError();

        String getArticleId();
    }

    interface Presenter extends BasePresenter {

        void loadArticle(Boolean forceRefresh);

    }
}
