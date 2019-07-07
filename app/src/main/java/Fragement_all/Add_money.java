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

import com.ultimatecoders.batuva.R;

import Controllers.Controller;
import Functionality_Class.RippleView;

/**
 * Created by Abhay0648 on 22-01-2017.
 */

public class Add_money extends Fragment implements RippleView.OnRippleCompleteListener {

    private View root_view;
    private RippleView bank_add_money,bank_transfer_money;
    private Context context;
    private Controller controller;
    private ImageView add_money,transfer_money;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root_view = inflater.inflate(R.layout.add_money, container, false);
        context = root_view.getContext();
        controller = new Controller();
        initialise_view(root_view);
        return root_view;
    }

    private void initialise_view(View root_view) {
        bank_add_money = (RippleView) root_view.findViewById(R.id.bank_add_money);
        bank_transfer_money = (RippleView) root_view.findViewById(R.id.bank_transfer_money);
        add_money = (ImageView) root_view.findViewById(R.id.add_money);
        transfer_money = (ImageView) root_view.findViewById(R.id.transfer_money);

        add_money.setImageResource(R.drawable.add_money);
        transfer_money.setImageResource(R.drawable.send_to_bank);

        add_money.setColorFilter(ContextCompat.getColor(context, R.color.button_bg));
        transfer_money.setColorFilter(ContextCompat.getColor(context, R.color.button_bg));


        bank_add_money.setOnRippleCompleteListener(this);
        bank_transfer_money.setOnRippleCompleteListener(this);
    }

    @Override
    public void onComplete(RippleView rippleView) {
        switch (rippleView.getId()){
            case R.id.bank_add_money:
                controller.Toast_show(context,getString(R.string.dummy_text));
                break;
            case R.id.bank_transfer_money:
                controller.Toast_show(context,getString(R.string.dummy_text));
                break;
        }
    }
}
