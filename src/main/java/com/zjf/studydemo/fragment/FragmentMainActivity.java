package com.zjf.studydemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.zjf.studydemo.R;


public class FragmentMainActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            //如果当前为竖屏 则修改为横屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }*/
        setContentView(R.layout.activity_fragment_main);
        initView();
//        initFragment();


    }

    private void initView() {
        findViewById(R.id.left_fragment_btn).setOnClickListener(this);
    }

    /**
     *
     */
    private void initFragment() {
//        FragmentManager fm = getSupportFragmentManager();
//        /*如果 视图容器中已经存在 获取到的Fragment队列就会返回
//        * 已经存在的原因是：当前activity被销毁时，fragment manage 把它保存下来，重建activity时新的 fragment manage 会首先获取保存的队列，然后重建fragment队列 ，恢复到原来的状态*/
//        Fragment fragment = fm.findFragmentById(R.id.main_left_fragment);
//        if (fragment == null) {
//
////            fragment = new ListFragment();
//        /*
//        * 创建并返回Transaction实例 一个新的fragment事物
//        * 添加操作
//        * 提交
//        * */
//            fm.beginTransaction().add(R.id.main_left_fragment, fragment).commit();
//        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_fragment_btn:
                Fragment anotherRightFragment = new AnotherRightFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                /*开启一个事务*/
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                /*向容器内添加碎片*/
                fragmentTransaction.add(R.id.main_right_Fragment_layout, anotherRightFragment, "anotherRight");
                /*添加一个反回栈*/
                fragmentTransaction.addToBackStack(null);
                /*提交事务*/
                fragmentTransaction.commit();
                break;

        }
    }

}
