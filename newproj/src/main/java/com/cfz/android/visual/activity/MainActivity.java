package com.cfz.android.visual.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.cfz.android.R;
import com.cfz.android.utils.CommonHelper;
import com.cfz.android.visual.activity.adapter.ViewPageFragmentAdapter;
import com.cfz.android.visual.activity.listener.FragmentActivityListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity implements FragmentActivityListener {
    TabHost mTabHost;
    ViewPager mViewPager;
    TabsAdapter mTabsAdapter;
    /**
     * this data used by fragment and activity
     */
    private HashMap<String, String> mFragmentActivityData;
    private View mNewIndicator;
    private View mOldIndicator;
    private View mUserIndicator;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        mViewPager = (ViewPager) findViewById(R.id.pager);
         mNewIndicator = LayoutInflater.from(this).inflate(R.layout.layout_tab_mini, null);
        ((TextView) mNewIndicator.findViewById(R.id.tab_label)).setText(R.string.tab_product_all);
         mOldIndicator = LayoutInflater.from(this).inflate(R.layout.layout_tab_mini, null);
        ((TextView) mOldIndicator.findViewById(R.id.tab_label)).setText(R.string.tab_product_get);
         mUserIndicator = LayoutInflater.from(this).inflate(R.layout.layout_tab_mini, null);
        ((TextView) mUserIndicator.findViewById(R.id.tab_label)).setText(R.string.tab_product_user);
        mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);

        mTabsAdapter.addTab(mTabHost.newTabSpec("simple").setIndicator(mNewIndicator),
                NewProductFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("contacts").setIndicator(mOldIndicator),
                ProductFinishedFragment.class, null);
        mTabsAdapter.addTab(mTabHost.newTabSpec("custom").setIndicator(mUserIndicator),
//                UserInfoFragment.class, null);
                UserLoginFragment.class, null);

        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
        }
        Map<String, String> mymap = new HashMap<String, String>();
        mymap.put("first", "firstvalue");
        mymap.put("second", "secondvalue");
        CommonHelper.saveObject2CommShare(this, "tester5", true);
    }

    @Override
    public void updateActivityData(HashMap<String, String> mActivityDataInfo) {
        mFragmentActivityData = mActivityDataInfo;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tab", mTabHost.getCurrentTabTag());
    }

    @Override
    protected int getActivityTitle() {
        return R.string.app_name;
    }


    @Override
    public void secondClick() {
        startActivity(new Intent(this, MoreActivity.class));
    }

    public class TabsAdapter extends ViewPageFragmentAdapter
            implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
        private final Context mContext;
        private final TabHost mTabHost;
        private final ViewPager mViewPager;
        private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

        public TabsAdapter(FragmentActivity activity, TabHost tabHost, ViewPager pager) {
            super(activity.getSupportFragmentManager());
            mContext = activity;
            mTabHost = tabHost;
            mViewPager = pager;
            mTabHost.setOnTabChangedListener(this);
            mViewPager.setAdapter(this);
            mViewPager.setOnPageChangeListener(this);
        }

        public void addTab(TabHost.TabSpec tabSpec, Class<?> clss, Bundle args) {
            tabSpec.setContent(new DummyTabFactory(mContext));
            String tag = tabSpec.getTag();

            TabInfo info = new TabInfo(tag, clss, args);
            mTabs.add(info);
            mTabHost.addTab(tabSpec);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mTabs.size();
        }

        @Override
        public Fragment getItem(int position) {
            TabInfo info = mTabs.get(position);
            return Fragment.instantiate(mContext, info.clss.getName(), info.args);
        }

        @Override
        public void onTabChanged(String tabId) {
            int position = mTabHost.getCurrentTab();
            mViewPager.setCurrentItem(position);
            if (tabId.equals("simple")) {
                mNewIndicator.setSelected(true);
                mOldIndicator.setSelected(false);
                mUserIndicator.setSelected(false);

            }else if (tabId.equals("contacts")){
                mNewIndicator.setSelected(false);
                mOldIndicator.setSelected(true);
                mUserIndicator.setSelected(false);

            }else if (tabId.equals("consume")) {
                mNewIndicator.setSelected(false);
                mOldIndicator.setSelected(false);
                mUserIndicator.setSelected(true);

            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            // Unfortunately when TabHost changes the current tab, it kindly
            // also takes care of putting focus on it when not in touch mode.
            // The jerk.
            // This hack tries to prevent this from pulling focus out of our
            // ViewPager.
            TabWidget widget = mTabHost.getTabWidget();
            int oldFocusability = widget.getDescendantFocusability();
            widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
            mTabHost.setCurrentTab(position);
            widget.setDescendantFocusability(oldFocusability);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }

         final class TabInfo {
            private final String tag;
            private final Class<?> clss;
            private final Bundle args;

            TabInfo(String _tag, Class<?> _class, Bundle _args) {
                tag = _tag;
                clss = _class;
                args = _args;
            }
        }

         class DummyTabFactory implements TabHost.TabContentFactory {
            private final Context mContext;

            public DummyTabFactory(Context context) {
                mContext = context;
            }

            @Override
            public View createTabContent(String tag) {
                View v = new View(mContext);
                v.setMinimumWidth(0);
                v.setMinimumHeight(0);
                return v;
            }
        }
    }
}
