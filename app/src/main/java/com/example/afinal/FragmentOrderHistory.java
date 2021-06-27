package com.example.afinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import Adapter.OrderHistoryAdapter;
import Api.OrderApi;
import Dto.OrderDetailDto;
import ViewModel.ShopViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentOrderHistory extends Fragment {

    private RecyclerView rclOrderHistory;
    private OrderHistoryAdapter orderHistoryAdapter;
    private ShopViewModel shopViewModel;
    private ArrayList<OrderDetailDto> orders = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order_history, container, false);
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);

        rclOrderHistory = v.findViewById(R.id.rclOrderHistory);
        orderHistoryAdapter = new OrderHistoryAdapter();
        rclOrderHistory.setAdapter(orderHistoryAdapter);
        rclOrderHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        rclOrderHistory.setFocusable(false);
        rclOrderHistory.setNestedScrollingEnabled(false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getOrderByIdCus();

    }

    private void getOrderByIdCus() {
        OrderApi.orderApi.getOrderDetailByIdCus().enqueue(new Callback<ArrayList<OrderDetailDto>>() {
            @Override
            public void onResponse(Call<ArrayList<OrderDetailDto>> call, Response<ArrayList<OrderDetailDto>> response) {
                orderHistoryAdapter.submitList(response.body());
                orderHistoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<OrderDetailDto>> call, Throwable t) {

            }
        });
    }
}