package com.zhaoweihao.zhihudaily.zhihudaily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.zhaoweihao.zhihudaily.R;

public class ZhihuDailyActivity extends AppCompatActivity {

    private ZhihuDailyFragment zhihuDailyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihu_daily);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        zhihuDailyFragment = ZhihuDailyFragment.newInstance();

        new ZhihuDailyPresenter(this,zhihuDailyFragment);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,zhihuDailyFragment).commit();
    }
}
