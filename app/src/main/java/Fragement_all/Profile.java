package Fragement_all;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ultimatecoders.batuva.R;

import Controllers.Controller;

public class Profile extends Fragment implements View.OnClickListener {
    private View root_view;
    private LinearLayout transition_history,add_money_from_bank,transfer_money,rate_us,share,contact_us,feed_back;
    private TextView sign_out,edit_profile;
    private Context context;
    private Controller controller;
    private ImageView profile_image,transition_history_img,add_money_from_bank_img,transfer_money_img,rate_us_img,share_img,
            contact_us_img,feed_back_img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root_view = inflater.inflate(R.layout.profile, container, false);
        context = root_view.getContext();
        controller = new Controller();
        initialise_view(root_view);
        return root_view;
    }

    private void initialise_view(View root_view) {
        transition_history = (LinearLayout) root_view.findViewById(R.id.transition_history);
        add_money_from_bank = (LinearLayout) root_view.findViewById(R.id.add_money_from_bank);
        transfer_money = (LinearLayout) root_view.findViewById(R.id.transfer_money);
        rate_us = (LinearLayout) root_view.findViewById(R.id.rate_us);
        share = (LinearLayout) root_view.findViewById(R.id.share);
        contact_us = (LinearLayout) root_view.findViewById(R.id.contact_us);

        profile_image = (ImageView) root_view.findViewById(R.id.profile_image);
        transition_history_img = (ImageView) root_view.findViewById(R.id.transition_history_img);
        add_money_from_bank_img = (ImageView) root_view.findViewById(R.id.add_money_from_bank_img);
        transfer_money_img = (ImageView) root_view.findViewById(R.id.transfer_money_img);
        rate_us_img = (ImageView) root_view.findViewById(R.id.rate_us_img);
        share_img = (ImageView) root_view.findViewById(R.id.share_img);
        contact_us_img = (ImageView) root_view.findViewById(R.id.contact_us_img);
        feed_back_img = (ImageView) root_view.findViewById(R.id.feed_back_img);

        sign_out =(TextView) root_view.findViewById(R.id.sign_out);
        edit_profile = (TextView) root_view.findViewById(R.id.edit_profile);

        transition_history.setOnClickListener(this);
        add_money_from_bank.setOnClickListener(this);
        transfer_money.setOnClickListener(this);
        rate_us.setOnClickListener(this);
        share.setOnClickListener(this);
        contact_us.setOnClickListener(this);
        sign_out.setOnClickListener(this);
        edit_profile.setOnClickListener(this);

        set_image_resources();

    }

    private void set_image_resources() {
        profile_image.setImageResource(R.drawable.profileicon);
        transition_history_img.setImageResource(R.drawable.transition);
        add_money_from_bank_img.setImageResource(R.drawable.add_money);
        transfer_money_img.setImageResource(R.drawable.send_to_bank);
        rate_us_img.setImageResource(R.drawable.rate);
        share_img.setImageResource(R.drawable.share);
        contact_us_img.setImageResource(R.drawable.contact_us);
        feed_back_img.setImageResource(R.drawable.feed_back);

        profile_image.setColorFilter(ContextCompat.getColor(context, R.color.button_bg), PorterDuff.Mode.MULTIPLY);
        transition_history_img.setColorFilter(ContextCompat.getColor(context, R.color.button_bg));
        add_money_from_bank_img.setColorFilter(ContextCompat.getColor(context, R.color.button_bg));
        transfer_money_img.setColorFilter(ContextCompat.getColor(context, R.color.button_bg));
        rate_us_img.setColorFilter(ContextCompat.getColor(context, R.color.button_bg));
        share_img.setColorFilter(ContextCompat.getColor(context, R.color.button_bg));
        contact_us_img.setColorFilter(ContextCompat.getColor(context, R.color.button_bg), PorterDuff.Mode.LIGHTEN);
        feed_back_img.setColorFilter(ContextCompat.getColor(context, R.color.button_bg));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.transition_history:
                controller.Toast_show(context,getString(R.string.dummy_text));
                break;
            case R.id.add_money_from_bank:
                controller.Toast_show(context,getString(R.string.dummy_text));
                break;
            case R.id.transfer_money:
                controller.Toast_show(context,getString(R.string.dummy_text));
                break;
            case R.id.rate_us:
                controller.Toast_show(context,getString(R.string.dummy_text));
                break;
            case R.id.share:
                controller.Toast_show(context,getString(R.string.dummy_text));
                break;
            case R.id.contact_us:
                controller.Toast_show(context,getString(R.string.dummy_text));
                break;
            case R.id.sign_out:
                controller.Toast_show(context,getString(R.string.dummy_text));
                break;
            case R.id.edit_profile:
                controller.Toast_show(context,getString(R.string.dummy_text));
                break;
        }
    }
}