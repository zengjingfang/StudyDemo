package com.zjf.studydemo.news;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zjf.studydemo.R;
import com.zjf.studydemo.util.DLog;


/**
 * Administrator
 * 2016/1/16
 */
public class NewsContentFragment extends Fragment {
    private View mView;
    private String mTitle;
    private String mContent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        DLog.d("on attach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DLog.d("on create");
        if (savedInstanceState != null) {
            this.mTitle = savedInstanceState.getString("title");
            this.mContent = savedInstanceState.getString("content");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.news_fragment_content, container, false);
        DLog.d("on create view" + savedInstanceState);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DLog.d("on activity created");
    }

    @Override
    public void onStart() {
        super.onStart();
        DLog.d("on start");
    }

    @Override
    public void onResume() {
        super.onResume();
        DLog.d("on resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        DLog.d("on pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        DLog.d("on stop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        DLog.d("on destroy view");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        DLog.d("on destroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        DLog.d("on detach");
    }

    /**
     * 刷新每一条新闻的内容
     *
     * @param newsTitle   新闻标题
     * @param newsContent 新闻内容
     */
    public void refresh(String newsTitle, String newsContent) {
        this.mTitle = newsTitle;
        this.mContent = newsContent;

        TextView title = (TextView) mView.findViewById(R.id.news_content_title);
        TextView content = (TextView) mView.findViewById(R.id.news_content_content);
        title.setText(newsTitle);
        content.setText(newsContent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("title", mTitle);
        outState.putString("content", mContent);
    }
}
