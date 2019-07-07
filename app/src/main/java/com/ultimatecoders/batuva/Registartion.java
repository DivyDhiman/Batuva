package com.ultimatecoders.batuva;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Controllers.Controller;

public class Registartion extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private Intent intent;
    private EditText registration_username, registration_password, registration_confirm_password, registration_email, registration_confirm_email;
    private Button registration_btn;
    private Controller controller;
    private String user_name, email_id, password;
    private TextView terms_conditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        context = Registartion.this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setNavigationBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
            getWindow().setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        }

        controller = new Controller();
        initialise();
    }

    private void initialise() {
        registration_username = (EditText) findViewById(R.id.registration_username);
        registration_password = (EditText) findViewById(R.id.registration_password);
        registration_confirm_password = (EditText) findViewById(R.id.registration_confirm_password);
        registration_email = (EditText) findViewById(R.id.registration_email);
        registration_confirm_email = (EditText) findViewById(R.id.registration_confirm_email);
        registration_btn = (Button) findViewById(R.id.registration_btn);
        terms_conditions = (TextView) findViewById(R.id.terms_conditions);

        terms_conditions.setOnClickListener(this);

        registration_btn.setOnClickListener(this);
    }

    private void check_all() {
        if (controller.Check_all_empty(registration_username)) {
            registration_username.setError(getString(R.string.empty_username));
        } else if (controller.Check_all_empty(registration_password)) {
            registration_password.setError(getString(R.string.empty_password));
        } else if (controller.Check_all_empty(registration_confirm_password)) {
            registration_confirm_password.setError(getString(R.string.empty_confirm_password));
        } else if (controller.Check_all_empty(registration_email)) {
            registration_email.setError(getString(R.string.empty_email));
        } else if (controller.Check_all_empty(registration_confirm_email)) {
            registration_confirm_email.setError(getString(R.string.empty_confirm_email));
        } else if (!controller.Check_all_email(registration_email)) {
            registration_email.setError(getString(R.string.valid_email));
        } else if (!controller.Password_length(registration_password, 6, 20)) {
            registration_password.setError(getString(R.string.password_length));
        } else {
            user_name = registration_username.getText().toString();
            email_id = registration_email.getText().toString();
            password = registration_password.getText().toString();

            if (!controller.Check_all_matches(registration_confirm_password, password)) {
                registration_confirm_password.setError(getString(R.string.matches_password));
            } else if (!controller.Check_all_matches(registration_confirm_email, email_id)) {
                registration_email.setError(getString(R.string.matches_email));
            } else {
                if (!controller.InternetCheck(context)) {
                    controller.Toast_show(context, getString(R.string.enable_internet));
                } else {

                    intent_type();
                    //API hit
                }
            }
        }
    }

    private void intent_type() {
        intent = new Intent(context, Dash_board.class);
        startActivity(intent);
        controller.Animation_forward(context);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        controller.Animation_backward(context);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.registration_btn:
                check_all();
                break;

            case R.id.terms_conditions:
                intent = new Intent(context, Terms_Conditions.class);
                startActivity(intent);
                controller.Animation_up(context);
                break;
        }
    }
}