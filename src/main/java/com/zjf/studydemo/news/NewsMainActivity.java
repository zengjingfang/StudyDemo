package com.zjf.studydemo.news;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import com.zjf.studydemo.R;

/**
 * Administrator
 * 2016/1/16
 */
public class NewsMainActivity extends FragmentActivity {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        /*此方法是在调用activity*/
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_main);
    }
}
