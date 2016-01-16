package com.zjf.studydemo.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zjf.studydemo.R;

import java.util.List;

/**
 * Administrator
 * 2016/1/16
 */
public class NewsAdapter extends BaseAdapter {
    private Context mContext;
    private List<NewsInfo> mNewsInfos;
    private int itemResourseId;

    public NewsAdapter(Context context, List<NewsInfo> newsInfos, int itemResourseId) {
        this.mContext = context;
        this.mNewsInfos = newsInfos;
        this.itemResourseId = itemResourseId;
    }

    @Override
    public int getCount() {
        return mNewsInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return mNewsInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(mNewsInfos.get(position).getId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(itemResourseId, null);
        }
        switch (itemResourseId) {
            case R.layout.news_item_title:
                setNewTitleItem(convertView, position);
                break;
            case R.layout.news_item__content:
                setNewsContentItem(convertView, position);
                break;
        }
        return convertView;
    }

    private void setNewsContentItem(View convertView, int position) {
        TextView title = (TextView) convertView.findViewById(R.id.news_item_content_title);
        title.setText(mNewsInfos.get(position).getTitle());
        TextView content = (TextView) convertView.findViewById(R.id.news_item_content_content);
        content.setText(mNewsInfos.get(position).getContent());

    }

    private void setNewTitleItem(View contentView, int position) {
        TextView textView = (TextView) contentView.findViewById(R.id.news_item_title_text);
        textView.setText(mNewsInfos.get(position).getTitle());
    }
}
