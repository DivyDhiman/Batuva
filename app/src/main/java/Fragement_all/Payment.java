package Fragement_all;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ultimatecoders.batuva.R;

import java.util.ArrayList;
import java.util.HashMap;

import Adapter_all.Adapter_all_view;

/**
 * Created by Abhay0648 on 22-01-2017.
 */

public class Payment extends Fragment {
    private View root_view;
    private RecyclerView payment_list;
    private ArrayList<HashMap<String, Object>> data;
    private HashMap<String, Object> data_sub;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root_view = inflater.inflate(R.layout.payment, container, false);
        context = root_view.getContext();
        initialise_view(root_view);
        return root_view;
    }

    private void initialise_view(View root_view) {
        payment_list = (RecyclerView) root_view.findViewById(R.id.payment_list);
        data = new ArrayList<>();

        data_sub = new HashMap<>();
        data_sub.put("name", context.getString(R.string.prepaid_recharge));
        data_sub.put("logo", R.drawable.prepost_recharge);
        data.add(data_sub);

        data_sub = new HashMap<>();
        data_sub.put("name", context.getString(R.string.postpaid_recharge));
        data_sub.put("logo", R.drawable.prepost_recharge);
        data.add(data_sub);

        data_sub = new HashMap<>();
        data_sub.put("name", context.getString(R.string.dth_recharge));
        data_sub.put("logo", R.drawable.dth_recharge);
        data.add(data_sub);

        data_sub = new HashMap<>();
        data_sub.put("name", context.getString(R.string.broad_band));
        data_sub.put("logo", R.drawable.broad_band);
        data.add(data_sub);

        data_sub = new HashMap<>();
        data_sub.put("name", context.getString(R.string.land_line));
        data_sub.put("logo", R.drawable.phone);
        data.add(data_sub);

        data_sub = new HashMap<>();
        data_sub.put("name", context.getString(R.string.datacard_recharge));
        data_sub.put("logo", R.drawable.datacard_recharge);
        data.add(data_sub);

        data_sub = new HashMap<>();
        data_sub.put("name", context.getString(R.string.insurance));
        data_sub.put("logo", R.drawable.insurence_recharge);
        data.add(data_sub);

        data_sub = new HashMap<>();
        data_sub.put("name", context.getString(R.string.electricity));
        data_sub.put("logo", R.drawable.electricity_recharge);
        data.add(data_sub);

        data_sub = new HashMap<>();
        data_sub.put("name", context.getString(R.string.gas));
        data_sub.put("logo", R.drawable.gas_recharge);
        data.add(data_sub);

        Adapter_all_view adapter_payment = new Adapter_all_view(payment_list.getContext(), data,R.layout.payment_adapter,getString(R.string.type_payment));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(payment_list.getContext(),3);
        payment_list.setLayoutManager(gridLayoutManager);
        payment_list.setHasFixedSize(true);
        payment_list.setAdapter(adapter_payment);

    }
}