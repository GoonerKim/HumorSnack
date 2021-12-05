package com.example.HumorSnack.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.HumorSnack.ui.Adapters.ViewPager_Adapter;
import com.example.HumorSnack.R;
import com.google.android.material.tabs.TabLayout;


public class AdLib_Fragment extends Fragment {

    private static final int NUM_PAGES =2 ;

    ViewPager viewPager;
    TabLayout tabLayout;

    public AdLib_Fragment() { };

    public static AdLib_Fragment newInstance() { return new AdLib_Fragment(); }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.adlib_main, container, false);
        viewPager = v.findViewById(R.id.viewPager);
        tabLayout = v.findViewById(R.id.tabs);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(2);

        View view1 = getLayoutInflater().inflate(R.layout.img_custom, null);
        view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.rank_selector);
        tabLayout.getTabAt(0).setCustomView(view1);

        View view2 = getLayoutInflater().inflate(R.layout.img_custom, null);
        view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.challenge_selector);
        tabLayout.getTabAt(1).setCustomView(view2);

        return v;
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPager_Adapter adapter = new ViewPager_Adapter(getChildFragmentManager());

        adapter.addFragment(new AdLib_Rk_Fragment().newInstance(),"");
        adapter.addFragment(new AdLib_Ch_Fragment(), "");

        viewPager.setAdapter(adapter);
    }

}
