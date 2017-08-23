package com.bbld.tsl_water.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bbld.tsl_water.R;
import com.bbld.tsl_water.adapter.ViewPagerAdapter;
import com.bbld.tsl_water.base.BaseActivity;
import com.bbld.tsl_water.fragment.Home01Fragment;
import com.bbld.tsl_water.fragment.Home02Fragment;
import com.bbld.tsl_water.fragment.Home03Fragment;
import com.bbld.tsl_water.fragment.Home04Fragment;
import com.bbld.tsl_water.fragment.Home05Fragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Home页
 * Created by likey on 2017/8/23.
 */

public class HomeActivity extends BaseActivity{
    @BindView(R.id.vpHome)
    ViewPager vpHome;
    @BindView(R.id.rgHome)
    RadioGroup rgHome;
    @BindView(R.id.rbHome01)
    RadioButton rbHome01;
    @BindView(R.id.rbHome02)
    RadioButton rbHome02;
    @BindView(R.id.rbHome03)
    RadioButton rbHome03;
    @BindView(R.id.rbHome04)
    RadioButton rbHome04;
    @BindView(R.id.rbHome05)
    RadioButton rbHome05;

    private ArrayList<Fragment> fragments;
    private ViewPagerAdapter vpadapter;

    @Override
    protected void initViewsAndEvents() {
        setAdapter();
        setListeners();
    }

    private void setListeners() {
        vpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rbHome01.setChecked(true);
                        break;
                    case 1:
                        rbHome02.setChecked(true);
                        break;
                    case 2:
                        rbHome03.setChecked(true);
                        break;
                    case 3:
                        rbHome04.setChecked(true);
                        break;
                    case 4:
                        rbHome05.setChecked(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rgHome.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rbHome01:
                        vpHome.setCurrentItem(0);
                        break;
                    case R.id.rbHome02:
                        vpHome.setCurrentItem(1);
                        break;
                    case R.id.rbHome03:
                        vpHome.setCurrentItem(2);
                        break;
                    case R.id.rbHome04:
                        vpHome.setCurrentItem(3);
                        break;
                    case R.id.rbHome05:
                        vpHome.setCurrentItem(4);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void setAdapter() {
        fragments=new ArrayList<Fragment>();
        fragments.add(new Home01Fragment());
        fragments.add(new Home02Fragment());
        fragments.add(new Home03Fragment());
        fragments.add(new Home04Fragment());
        fragments.add(new Home05Fragment());
        vpadapter=new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        vpHome.setAdapter(vpadapter);
        vpHome.setOffscreenPageLimit(0);
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_home;
    }
}
