package com.zjf.studydemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zjf.studydemo.R;

/**
 * Administrator
 * 2016/1/13
 */
public class RightFragment extends Fragment {
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.right_fragment, container, false);
        return mView;
    }

}
