package com.ultimatecoders.batuva;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import Functionality_Class.SharedPrefSave;

/**
 * Created by Abhay dhiman
 */


public class Splash extends Activity implements Animation.AnimationListener {

    private Context context;
    private Intent intent;
    private ImageView splashlogo;
    private ImageView splash_title;
    private Animation mAnim = null;
    private boolean checksplash, status;
    private SharedPrefSave sharedPrefSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        context = Splash.this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setNavigationBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
            getWindow().setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        }

        checksplash = false;
        sharedPrefSave = new SharedPrefSave(context);
        status = sharedPrefSave.getBoolean("status");

        splashlogo = (ImageView) findViewById(R.id.splash_logo);
        splash_title = (ImageView) findViewById(R.id.splash_title);
        splash_title.setVisibility(View.GONE);
        mAnim = AnimationUtils.loadAnimation(this, R.anim.translate);
        mAnim.setAnimationListener(this);
        splashlogo.clearAnimation();
        splashlogo.setAnimation(mAnim);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if (!checksplash) {
            splash_title.setVisibility(View.VISIBLE);

            mAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            mAnim.setAnimationListener(this);

            splash_title.startAnimation(mAnim);
            checksplash = true;

        } else {
            if (status) {
                intent = new Intent(context, Dash_board.class);
                startActivity(intent);
                finish();

            } else {
                intent = new Intent(context, AfterSplash.class);
                startActivity(intent);
                finish();

            }
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
