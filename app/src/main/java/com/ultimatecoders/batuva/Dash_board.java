package com.ultimatecoders.batuva;


import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import Adapter_all.ViewPagerAdapter_home;
import Controllers.Controller;
import Fragement_all.Home;
import Fragement_all.Profile;
import Fragement_all.Special_offers;
import Fragement_all.Update;

public class Dash_board extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private Controller controller;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter_home view_pager_home;
    private TextView title,balance;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dash_board);

        context = Dash_board.this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setNavigationBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
            getWindow().setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        }

        controller = new Controller();
        set_action_bar();

        initialise();
    }

    private void initialise() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawerLayout);

        setupViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressWarnings("ConstantConditions")
            @Override
            public void onPageSelected(int position) {
                switch (position) {

                    case 0:
                        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#ff6401"), PorterDuff.Mode.SRC_IN);
                        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#717171"), PorterDuff.Mode.SRC_IN);
                        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#717171"), PorterDuff.Mode.SRC_IN);

                        break;

                    case 1:
                        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#717171"), PorterDuff.Mode.SRC_IN);
                        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#ff6401"), PorterDuff.Mode.SRC_IN);
                        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#717171"), PorterDuff.Mode.SRC_IN);

                        break;

                    case 2:
                        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#717171"), PorterDuff.Mode.SRC_IN);
                        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#717171"), PorterDuff.Mode.SRC_IN);
                        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#ff6401"), PorterDuff.Mode.SRC_IN);
                        break;


                    default:
                        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#ff6401"), PorterDuff.Mode.SRC_IN);
                        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#717171"), PorterDuff.Mode.SRC_IN);
                        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#717171"), PorterDuff.Mode.SRC_IN);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

    }

    @SuppressWarnings("ConstantConditions")
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.offers);
        tabLayout.getTabAt(2).setIcon(R.drawable.update);

        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#ff6401"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.parseColor("#717171"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#717171"), PorterDuff.Mode.SRC_IN);
    }

    private void setupViewPager(ViewPager viewPager) {
        view_pager_home = new ViewPagerAdapter_home(getSupportFragmentManager());
        view_pager_home.addFrag(new Home(), getString(R.string.home));
        view_pager_home.addFrag(new Special_offers(), getString(R.string.offers));
        view_pager_home.addFrag(new Update(), getString(R.string.update));

        viewPager.setAdapter(view_pager_home);
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
        } else {
            finish();
            controller.Animation_backward(context);
        }
    }

    private void set_action_bar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView back_btn = (ImageView) toolbar.findViewById(R.id.back_btn);
        ImageView app_logo = (ImageView) toolbar.findViewById(R.id.app_logo);
        ImageView menu_btn = (ImageView) toolbar.findViewById(R.id.menu_btn);
        title = (TextView) toolbar.findViewById(R.id.title);
        balance = (TextView) toolbar.findViewById(R.id.balance);
        back_btn.setVisibility(View.GONE);
        menu_btn.setOnClickListener(this);

        replace_fragment();
    }

    private void replace_fragment() {
        Profile profile = new Profile();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.replace_fragment, profile);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.menu_btn:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
        }
    }
}
