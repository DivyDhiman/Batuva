package Adapter_all;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ultimatecoders.batuva.R;

import java.util.ArrayList;
import java.util.HashMap;

import Controllers.Controller;

public class Adapter_all_view extends RecyclerView.Adapter<Adapter_all_view.ViewHolder> {

    private Context context;
    private ArrayList<HashMap<String, Object>> data;
    private HashMap<String, Object> data_sub;
    private ArrayList<String> click_data = new ArrayList<>();
    private Controller controller;
    private String type;
    private int layout_pass;


    public Adapter_all_view(Context context, ArrayList<HashMap<String, Object>> data,int layout_pass, String type) {
        this.context = context;
        this.data = data;
        this.type = type;
        this.layout_pass = layout_pass;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(layout_pass, parent, false);
        controller = new Controller();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        data_sub = data.get(position);

        if (type.equals(context.getString(R.string.type_e_book))) {
            call_method(1, holder);
        } else if (type.equals(context.getString(R.string.type_payment))) {
            call_method(2, holder);
        }
    }

    private void call_method(int i, ViewHolder holder) {
        switch (i) {
            case 1:
                holder.send_add_receive_txt.setText(data_sub.get("cash").toString());
                holder.to_from_txt.setText(data_sub.get("to").toString());
                holder.time_all.setText(data_sub.get("time").toString());
                holder.logo_image.setImageResource((Integer) data_sub.get("logo"));
                holder.logo_image.setColorFilter(ContextCompat.getColor(context, R.color.button_bg));

                holder.need_help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        controller.Toast_show(context, context.getString(R.string.dummy_text));
                    }
                });
                break;

            case 2:
                holder.payment_logo.setImageResource((Integer) data_sub.get("logo"));
                holder.payment_logo.setColorFilter(ContextCompat.getColor(context, R.color.button_bg), PorterDuff.Mode.ADD);
                holder.payment_txt.setText(data_sub.get("name").toString());

                break;

        }
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView send_add_receive_txt, to_from_txt, time_all, need_help,payment_txt;
        ImageView logo_image,payment_logo;

        public ViewHolder(View view) {
            super(view);
            if (type.equals(context.getString(R.string.type_e_book))) {
                logo_image = (ImageView) view.findViewById(R.id.logo_image);
                send_add_receive_txt = (TextView) view.findViewById(R.id.send_add_receive_txt);
                to_from_txt = (TextView) view.findViewById(R.id.to_from_txt);
                time_all = (TextView) view.findViewById(R.id.time_all);
                need_help = (TextView) view.findViewById(R.id.need_help);
            } else if (type.equals(context.getString(R.string.type_payment))) {
                payment_logo = (ImageView) view.findViewById(R.id.payment_logo);
                payment_txt = (TextView) view.findViewById(R.id.payment_txt);
            }
        }
    }
}