package com.zjf.studydemo.news;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.zjf.studydemo.R;

/**
 * zengjingfang
 * 2016/1/16
 * <p/>
 * 当为首页为单页的时候
 * 新闻内容页需要一个宿主Activity来管理
 * 本Activity 重复使用双页时使用的Fragment 既com.zjf.studydemo.news.NewsContentFragment 好处就是，我们对于新闻内容的详细处理可以重复使用，我们只需要给其提供必要的数据
 * 获得com.zjf.studydemo.news.NewsContentFragment 的公共接口 刷新数据即可
 */
public class NewsContentActivity extends FragmentActivity {
    /**
     * 跳转到改activity调用本方法即可
     *
     * @param context     跳转上一个activity的实例
     * @param newsTitle   新闻标题
     * @param newsContent 新闻内容
     */
    public static void startAction(Context context, String newsTitle, String newsContent) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title", newsTitle);
        intent.putExtra("news_content", newsContent);
        context.startActivity(intent);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_content);
        initData(getIntent());

    }

    /**
     * 初始化数据
     *
     * @param intent 信使
     */
    private void initData(Intent intent) {
        String title = intent.getStringExtra("news_title");
        String content = intent.getStringExtra("news_content");
        /*宿主 activity 获得 fragment管理器*/
        FragmentManager fragmentManager = getSupportFragmentManager();
        /* 获得该activity 布局中的fragment*/
        NewsContentFragment newsContentFragment = (NewsContentFragment) fragmentManager.findFragmentById(R.id.news_content_fragment);
        /*调用fragment的方法刷新*/
        newsContentFragment.refresh(title, content);
    }


}
