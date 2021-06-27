package com.example.afinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Adapter.CakeCategoryListAdapter;

public class CakeListFragment extends Fragment {

    View v;
    CakeCategoryListAdapter cakeCategoryListAdapter;
    RecyclerView rclCakeCategoryList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_cake_list, container, false);
        rclCakeCategoryList = v.findViewById(R.id.rclListCakeCategory);
        cakeCategoryListAdapter = new CakeCategoryListAdapter(getContext());
        rclCakeCategoryList.setAdapter(cakeCategoryListAdapter);
        rclCakeCategoryList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rclCakeCategoryList.setFocusable(false);
        rclCakeCategoryList.setNestedScrollingEnabled(false);
        return v;
    }
}