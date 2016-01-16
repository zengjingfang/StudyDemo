package com.zjf.studydemo.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zjf.studydemo.R;


/**
 * Administrator
 * 2016/1/16
 */
public class NewsContentFragment extends Fragment {
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.news_fragment_content, container, false);
        return mView;
    }

    /**
     * 刷新每一条新闻的内容
     *
     * @param newsTitle   新闻标题
     * @param newsContent 新闻内容
     */
    public void refresh(String newsTitle, String newsContent) {
        TextView title = (TextView) mView.findViewById(R.id.news_content_title);
        TextView content = (TextView) mView.findViewById(R.id.news_content_content);
        title.setText(newsTitle);
        content.setText(newsContent);
    }
}
