package Fragement_all;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ultimatecoders.batuva.R;

import Adapter_all.ViewPagerAdapter_home;
import Controllers.Controller;

public class Home extends Fragment {
    private View root_view;
    private Context context;
    private Controller controller;
    private ViewPager viewPager;
    private ViewPagerAdapter_home view_pager_home;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        root_view = inflater.inflate(R.layout.home, container, false);
        context = root_view.getContext();
        controller = new Controller();
        initialise_view(root_view);
        return root_view;
    }

    private void initialise_view(View root_view) {

        viewPager = (ViewPager) root_view.findViewById(R.id.viewPager);

        setupViewPager(viewPager);
        tabLayout = (TabLayout) root_view.findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        view_pager_home = new ViewPagerAdapter_home(getChildFragmentManager());
        view_pager_home.addFrag(new Payment(), getString(R.string.payment_sub));
        view_pager_home.addFrag(new Add_money(), getString(R.string.add_money_sub));
        view_pager_home.addFrag(new E_book(), getString(R.string.e_book_sub));
        view_pager_home.addFrag(new Accept_payment(), getString(R.string.accept_payment_sub));
        viewPager.setAdapter(view_pager_home);
    }
}