package com.zjf.studydemo.news;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zjf.studydemo.R;
import com.zjf.studydemo.util.DLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Administrator
 * 2016/1/16
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {
    private View mView;
    /**
     * 新闻标题列表ListView
     */
    private ListView mNewsTitleLV;
    /**
     * 新闻内容适配器
     */
    private NewsAdapter mNewsAdapter;
    /**
     * 新闻列表信息
     */
    private List<NewsInfo> mNewsInfos;
    /**
     * 是否为双面板 标题fragment 和 内容fragment 是否在一个界面
     */
    private boolean mIsTwoPane;


    private OnNewsTitleFragmentClick mOnNewsTitleFragmentClick;


    public void setOnNewsTitleFragmentClick(OnNewsTitleFragmentClick onNewsTitleFragmentClick) {
        mOnNewsTitleFragmentClick = onNewsTitleFragmentClick;
    }

    /**
     * fragment 生命周期 第一步 关联到宿主Activity 碎片和活动关联的时候调用
     * 注意：一般初始化数据操作在该周期内完成
     *
     * @param activity 宿主activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mNewsInfos = getNewsInfos();
        mNewsAdapter = new NewsAdapter(activity, mNewsInfos, R.layout.news_item_title);
        DLog.d("on attach :" + mNewsInfos.size());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DLog.d("on create  ,savedInstanceState: " + savedInstanceState);
    }

    /**
     * 当碎片创建视图时调用 三
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DLog.d("on create view ,savedInstanceState: " + savedInstanceState);
        mView = inflater.inflate(R.layout.news_fragment_title, container, false);
              /*UI*/
        mNewsTitleLV = (ListView) mView.findViewById(R.id.news_title_lv);
        mNewsTitleLV.setAdapter(mNewsAdapter);
        mNewsTitleLV.setOnItemClickListener(this);


        return mView;
    }

    /**
     * 当确保与碎片相关的活动时调用
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DLog.d("on activity created ,savedInstanceState: " + savedInstanceState);
        /*判断宿主 activity 是否把 内容的 布局 加载*/
        if (getActivity().findViewById(R.id.news_main_content_layout) != null) {
            /*双页布局*/
            mIsTwoPane = true;
        } else {
            /*单页布局*/
            mIsTwoPane = false;
        }
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NewsInfo newsInfo = mNewsInfos.get(position);
       /* if (mIsTwoPane) {
            *//*双页模式---与content fragment 通信*//*
            NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_main_content_fragment);
            newsContentFragment.refresh(newsInfo.getTitle(), newsInfo.getContent());

        } else {
            *//*如果是单页模式---直接启动内容 activity*//*
            NewsContentActivity.startAction(getActivity(), newsInfo.getTitle(), newsInfo.getContent());
        }*/

        if (mOnNewsTitleFragmentClick != null) {
            mOnNewsTitleFragmentClick.onNewsListItemClick(newsInfo);
        }
    }

    public interface OnNewsTitleFragmentClick {
        void onNewsListItemClick(NewsInfo newsInfo);
    }

    public List<NewsInfo> getNewsInfos() {
        mNewsInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NewsInfo newsInfo = new NewsInfo();
            newsInfo.setId(i + "");
            newsInfo.setTitle("---title---" + i + "----");
            newsInfo.setContent("---content---" + i + "----");
            mNewsInfos.add(newsInfo);
        }
        return mNewsInfos;
    }

    /**
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        DLog.d("on save instance state");
        Gson gson = new Gson();

        outState.putString("tile_save_news_infos", gson.toJson(mNewsInfos));
        super.onSaveInstanceState(outState);
    }

    /**
     * 在进行 transaction 时进行
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }
}
