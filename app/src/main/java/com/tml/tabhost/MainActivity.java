package com.tml.tabhost;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import com.tml.tabhost.adapter.TabsPagerAdapter;

import java.util.List;
import java.util.Vector;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity implements TabHost.OnTabChangeListener,ViewPager.OnPageChangeListener {
    private TabHost tabHost;
    private ViewPager viewPager;
    private TabsPagerAdapter myTabsAdapter;
    int i=0;

    class FakeContent implements TabHost.TabContentFactory {
        private final Context mContext;
        public FakeContent(Context context) {
            mContext=context;
        }

        @Override
        public View createTabContent(String tag) {

            View v=new View(mContext);
            v.setMinimumHeight(0);
            v.setMinimumWidth(0);
            return v;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i++;

        this.initializeTabHost(savedInstanceState);

        this.initializeViewPager();
    }

    private void initializeViewPager() {
        List<android.support.v4.app.Fragment> fragments=new Vector<android.support.v4.app.Fragment>();

        fragments.add(new Tatva());
        fragments.add(new Moksh());
        fragments.add(new Lakshya());

        this.myTabsAdapter=new TabsPagerAdapter(getSupportFragmentManager(),fragments);
        this.viewPager=(ViewPager)super.findViewById(R.id.viewPager);
        this.viewPager.setAdapter(this.myTabsAdapter);
        this.viewPager.setOnPageChangeListener(this);

        onRestart();
    }

    private void initializeTabHost(Bundle args) {
        tabHost=(TabHost)findViewById(android.R.id.tabhost);

        tabHost.setup();


        TabHost.TabSpec tabSpec;

        tabSpec=tabHost.newTabSpec("Tatva");
        tabSpec.setIndicator("Tatva");
        tabSpec.setContent(new FakeContent(this));
        tabHost.addTab(tabSpec);

        tabHost.setOnTabChangedListener(this);

        tabSpec=tabHost.newTabSpec("Moksh");
        tabSpec.setIndicator("Moksh");
        tabSpec.setContent(new FakeContent(this));
        tabHost.addTab(tabSpec);

        tabHost.setOnTabChangedListener(this);

        tabSpec=tabHost.newTabSpec("Lakshya");
        tabSpec.setIndicator("Lakshya");
        tabSpec.setContent(new FakeContent(this));
        tabHost.addTab(tabSpec);

        tabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onTabChanged(String tabId) {

        int pos=this.tabHost.getCurrentTab();
        this.viewPager.setCurrentItem(pos);

        HorizontalScrollView hScrollView=(HorizontalScrollView)findViewById(R.id.hScrollView);
        View tabView=tabHost.getCurrentTabView();
        int scrollPos=tabView.getLeft()-(hScrollView.getWidth()-tabView.getWidth())/2;
        hScrollView.smoothScrollTo(scrollPos,0);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d("T","State:"+state);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        Log.d("T","State:"+position+positionOffset+positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("T","State Selected:"+position);
        this.tabHost.setCurrentTab(position);

    }
}