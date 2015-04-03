package com.polidea.hierarchyviewerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import com.polidea.hierarchyviewer.Config;
import com.polidea.hierarchyviewer.HierarchyViewer;
import com.polidea.hierarchyviewerdemo.fragments.ListViewFragment;
import com.polidea.hierarchyviewerdemo.fragments.RecyclerViewFragment;

public class ScrollingViewsActivity extends ActionBarActivity{
    MyAdapter mAdapter;

    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);

        mAdapter = new MyAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        // Watch for button clicks.
        Button button = (Button)findViewById(R.id.goto_first);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(0);
            }
        });
        button = (Button)findViewById(R.id.goto_last);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(1);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        HierarchyViewer.start(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        HierarchyViewer.shouldStop(this);
    }

    public static class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return new RecyclerViewFragment();
            } else {
                return new ListViewFragment();
            }
        }
    }
}
