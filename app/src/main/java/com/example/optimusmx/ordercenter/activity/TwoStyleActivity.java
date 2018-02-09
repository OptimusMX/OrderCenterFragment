package com.example.optimusmx.ordercenter.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.optimusmx.ordercenter.R;
import com.example.optimusmx.ordercenter.fragment.TabFourFragment;
import com.example.optimusmx.ordercenter.fragment.TabOneFragment;
import com.example.optimusmx.ordercenter.fragment.TabThreeFragment;
import com.example.optimusmx.ordercenter.fragment.TabTwoFragment;

import java.util.ArrayList;
import java.util.List;


public class TwoStyleActivity extends AppCompatActivity {


    private TabLayout tlActivitytwoTitle;
    private List<Fragment> fragmentList;
    private String[] arrTitle=new String[]{"全部","待付款","待评价","退款"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        //初始化数据
        initData();
        //初始化点击监听事件
        initOnclickListener();
    }

    /**
     * 初始化数据
     */
    private void initData(){
        //初始化Tablayout的ID
        tlActivitytwoTitle= (TabLayout)findViewById(R.id.tl_activitytwo_title);
        //初始化ViewPager的ID
        ViewPager vpActivitytwoContent=(ViewPager)findViewById(R.id.vp_activitytwo_content);
        fragmentList= new ArrayList<Fragment>();
        fragmentList.add(new TabOneFragment());
        fragmentList.add(new TabTwoFragment());
        fragmentList.add(new TabThreeFragment());
        fragmentList.add(new TabFourFragment());
        MyAdapter myAdapter=new MyAdapter(getSupportFragmentManager());
        vpActivitytwoContent.setAdapter(myAdapter);
        tlActivitytwoTitle.setupWithViewPager(vpActivitytwoContent);
    }
    /**
     * 初始点击事件
     */
    private void initOnclickListener(){
    }

    /**
     * ViewAdapter初始化
     */
    private class MyAdapter extends FragmentPagerAdapter{
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return arrTitle[position];
        }
    }
}
