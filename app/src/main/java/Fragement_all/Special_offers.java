package Fragement_all;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ultimatecoders.batuva.R;

import Controllers.Controller;

public class Special_offers extends Fragment {

    private View root_view;
    private Context context;
    private Controller controller;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root_view = inflater.inflate(R.layout.e_book, container, false);
        context = root_view.getContext();
        controller = new Controller();
        initialise_view(root_view);
        return root_view;
    }

    private void initialise_view(View root_view) {

    }

}
