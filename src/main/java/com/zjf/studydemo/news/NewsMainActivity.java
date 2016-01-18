package com.zjf.studydemo.news;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.zjf.studydemo.R;
import com.zjf.studydemo.util.DLog;

/**
 * Administrator
 * 2016/1/16
 */
public class NewsMainActivity extends FragmentActivity implements NewsTitleFragment.OnNewsTitleFragmentClick {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_main);
        DLog.d("on create");

        NewsTitleFragment newsTitleFragment = (NewsTitleFragment) getSupportFragmentManager().findFragmentById(R.id.news_main_title_fragment);
        newsTitleFragment.setOnNewsTitleFragmentClick(this);

        NewsDataCtrl.insertNewsCategory();
        NewsDataCtrl.insertNewsItem();
    }

    @Override
    protected void onStart() {
        super.onStart();
        DLog.d("on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        DLog.d("on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        DLog.d("on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        DLog.d("on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DLog.d("on destroy");
    }

    /**
     * 注意：Fragment 与 Activity 或者 Fragment 之间的通信 最好是要求 在宿主Activity 之间完成，这样便于宿主对依赖的Fragment进行管理
     * 管理 NewsTileFragment 的点击事件 实现 Fragment和Activity之间的通信，以及和NewsContentFragment之前的通信
     *
     * @param newsInfo 新闻信息
     */
    @Override
    public void onNewsListItemClick(NewsInfo newsInfo) {

        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_main_content_fragment);
        newsContentFragment.refresh(newsInfo.getTitle(), newsInfo.getContent());
    }
}
