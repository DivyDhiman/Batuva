package com.ultimatecoders.batuva;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import Adapter_all.ViewPagerAdapter;
import Controllers.Controller;

/**
 * Created by Abhay dhiman
 */

public class AfterSplash extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ImageView firstdot, seconddot, thirddot, fourthdot, fifthdot;
    private int color;
    private Context context;
    private TextView tvtitle, tvdescription;
    private Intent intent;
    private int[] mResources = {
            R.drawable.bg_first,
            R.drawable.bg_second,
            R.drawable.bg_third,
            R.drawable.bg_fourth,
            R.drawable.bg_fifth
    };

    private Controller controller;
    static AfterSplash afterSplash;

    private Button tvlogin, tvregister;
    private String[] mIntroMsges, mdesMsges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_splash);

        context = AfterSplash.this;
        afterSplash = this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setNavigationBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
            getWindow().setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        }

        controller = new Controller();

        mIntroMsges = new String[]{
                getResources().getString(R.string.title1),
                getResources().getString(R.string.title2),
                getResources().getString(R.string.title3),
                getResources().getString(R.string.title4),
                getResources().getString(R.string.title5)
        };

        mdesMsges = new String[]{
                getResources().getString(R.string.description1),
                getResources().getString(R.string.description2),
                getResources().getString(R.string.description3),
                getResources().getString(R.string.description4),
                getResources().getString(R.string.description5)
        };

        initilize();
    }

    private void initilize() {


        ViewPagerAdapter adapter = new ViewPagerAdapter(this, mResources);
        ViewPager myPager = (ViewPager) findViewById(R.id.viewPager);
        myPager.setAdapter(adapter);
        myPager.setCurrentItem(0);
        myPager.addOnPageChangeListener(this);

        firstdot = (ImageView) findViewById(R.id.firstdot);
        seconddot = (ImageView) findViewById(R.id.seconddot);
        thirddot = (ImageView) findViewById(R.id.thirddot);
        fourthdot = (ImageView) findViewById(R.id.fourthdot);
        fifthdot = (ImageView) findViewById(R.id.fifthdot);
        tvlogin = (Button) findViewById(R.id.tvlogin);
        tvregister = (Button) findViewById(R.id.tvregister);
        tvtitle = (TextView) findViewById(R.id.tvtitle);
        tvdescription = (TextView) findViewById(R.id.tvdescription);

        tvlogin.setOnClickListener(this);
        tvregister.setOnClickListener(this);

        color = Color.parseColor("#FFFFFF");

        firstdot.setImageResource(R.drawable.dotselected);
        seconddot.setImageResource(R.drawable.dotunselected);
        thirddot.setImageResource(R.drawable.dotunselected);
        fourthdot.setImageResource(R.drawable.dotunselected);
        fifthdot.setImageResource(R.drawable.dotunselected);

        firstdot.setColorFilter(color);
        seconddot.setColorFilter(color);
        thirddot.setColorFilter(color);
        fourthdot.setColorFilter(color);
        fifthdot.setColorFilter(color);

        tvtitle.setText(mIntroMsges[0]);
        tvdescription.setText(mdesMsges[0]);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tvlogin:
                intent = new Intent(context, Login_activity.class);
                startActivity(intent);
                controller.Animation_forward(context);

                break;

            case R.id.tvregister:
                intent = new Intent(context, Registartion.class);
                startActivity(intent);
                controller.Animation_forward(context);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int dotpostion) {
        if (dotpostion == 0) {

            firstdot.setImageResource(R.drawable.dotselected);
            seconddot.setImageResource(R.drawable.dotunselected);
            thirddot.setImageResource(R.drawable.dotunselected);
            fourthdot.setImageResource(R.drawable.dotunselected);
            fifthdot.setImageResource(R.drawable.dotunselected);
            tvtitle.setText(mIntroMsges[0]);
            tvdescription.setText(mdesMsges[0]);

        } else if (dotpostion == 1) {

            firstdot.setImageResource(R.drawable.dotunselected);
            seconddot.setImageResource(R.drawable.dotselected);
            thirddot.setImageResource(R.drawable.dotunselected);
            fourthdot.setImageResource(R.drawable.dotunselected);
            fifthdot.setImageResource(R.drawable.dotunselected);

            tvtitle.setText(mIntroMsges[1]);
            tvdescription.setText(mdesMsges[1]);

        } else if (dotpostion == 2) {

            firstdot.setImageResource(R.drawable.dotunselected);
            seconddot.setImageResource(R.drawable.dotunselected);
            thirddot.setImageResource(R.drawable.dotselected);
            fourthdot.setImageResource(R.drawable.dotunselected);
            fifthdot.setImageResource(R.drawable.dotunselected);

            tvtitle.setText(mIntroMsges[2]);
            tvdescription.setText(mdesMsges[2]);

        } else if (dotpostion == 3) {

            firstdot.setImageResource(R.drawable.dotunselected);
            seconddot.setImageResource(R.drawable.dotunselected);
            thirddot.setImageResource(R.drawable.dotunselected);
            fourthdot.setImageResource(R.drawable.dotselected);
            fifthdot.setImageResource(R.drawable.dotunselected);

            tvtitle.setText(mIntroMsges[3]);
            tvdescription.setText(mdesMsges[3]);

        } else if (dotpostion == 4) {

            firstdot.setImageResource(R.drawable.dotunselected);
            seconddot.setImageResource(R.drawable.dotunselected);
            thirddot.setImageResource(R.drawable.dotunselected);
            fourthdot.setImageResource(R.drawable.dotunselected);
            fifthdot.setImageResource(R.drawable.dotselected);

            tvtitle.setText(mIntroMsges[4]);
            tvdescription.setText(mdesMsges[4]);

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}