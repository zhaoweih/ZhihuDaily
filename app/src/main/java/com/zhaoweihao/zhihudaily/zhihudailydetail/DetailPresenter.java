package com.zhaoweihao.zhihudaily.zhihudailydetail;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.zhaoweihao.zhihudaily.data.Detail;
import com.zhaoweihao.zhihudaily.data.OnStringListener;
import com.zhaoweihao.zhihudaily.data.StringModelImpl;

/**
 * Created by por on 2018/4/5.
 */

public class DetailPresenter implements DetailContrace.Presenter, OnStringListener{

    private static final String TAG = "DetailPresenter";

    private DetailContrace.View view;
    private Context context;
    private StringModelImpl model;
    private Detail detail;

    public DetailPresenter(Context context, DetailContrace.View view) {
        this.view = view;
        this.context = context;
        this.view.setPresenter(this);
        model = new StringModelImpl(context);
    }

    @Override
    public void loadArticle(Boolean forceRefresh) {
        view.startLoading();
        Log.d(TAG,view.getArticleId());
        if (forceRefresh) {

        }
        model.load("https://news-at.zhihu.com/api/4/news/"+view.getArticleId(),this);
    }
    @Override
    public void start() {

    }

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Detail detail = gson.fromJson(result, Detail.class);
        view.showResult(detail);
        view.stopLoading();
    }

    @Override
    public void onError(String error) {
        view.showLoadError();
        view.stopLoading();
    }

}
