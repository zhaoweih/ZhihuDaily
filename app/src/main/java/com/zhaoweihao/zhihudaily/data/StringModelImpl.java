package com.zhaoweihao.zhihudaily.data;

import android.content.Context;

import com.zhaoweihao.zhihudaily.util.HttpUtil;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by zhao weihao 2018/4/5.
 */

public class StringModelImpl {

    private Context context;

    public StringModelImpl(Context context) { this.context = context; }

    public void load(String url, final OnStringListener listener) {
//        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String s) {
//                listener.onSuccess(s);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                listener.onError(volleyError);
//            }
//        });
//        VolleySingleton.getVolleySingleton(context).addToRequestQueue(request);
        HttpUtil.sendOkHttpRequest(url,new okhttp3.Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                listener.onError(e.toString());
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                //网络请求成功
                String s = response.body().string();
                listener.onSuccess(s);
            }
        });
    }
}
