package com.zcm.wanandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.zcm.wanandroid.ui.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * main
 */
public class MainActivity extends AppCompatActivity {

    private AlphaTabsIndicator alphaTabsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager mViewPger =  findViewById(R.id.mViewPager);
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPger.setAdapter(mainAdapter);
        mViewPger.addOnPageChangeListener(mainAdapter);

        alphaTabsIndicator =  findViewById(R.id.alphaIndicator);
        alphaTabsIndicator.setViewPager(mViewPger);

        alphaTabsIndicator.setTabCurrenItem(0);
        /*alphaTabsIndicator.getTabView(0).showNumber(6);
        alphaTabsIndicator.getTabView(1).showNumber(888);
        alphaTabsIndicator.getTabView(2).showNumber(88);*/
        //alphaTabsIndicator.getTabView(3).showPoint();

    }

    private class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

        private List<Fragment> fragments = new ArrayList<>();
        private String[] titles = {"首页", "分类", "我的"};

        private MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(HomeFragment.newInstance(titles[0]));
            fragments.add(HomeFragment.newInstance(titles[1]));
            fragments.add(HomeFragment.newInstance(titles[2]));
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (0 == position) {
                alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);
            } else if (2 == position) {
                alphaTabsIndicator.getCurrentItemView().removeShow();
            } else if (3 == position) {
                alphaTabsIndicator.removeAllBadge();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
