package com.zcm.wanandroid.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zcm.wanandroid.R;

/**
 * Created by zcm on 2018/3/15.
 * home
 */

public class HomeFragment extends Fragment {
    public static HomeFragment newInstance(String from) {

        Bundle args = new Bundle();

        args.putString("home",from);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_home, container, false);
    }
}
