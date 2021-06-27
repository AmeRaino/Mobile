package com.example.afinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import Model.Cake;
import ViewModel.ShopViewModel;

public class CakeDetailFragment extends Fragment {

    private ShopViewModel shopViewModel;
    private Cake cakeDetail;
    private TextView txtNameCake;
    private TextView txtCategory;
    private TextView txtPrice;
    private TextView txtQuantity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cake_detail, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtNameCake = view.findViewById(R.id.txtNameDetailCake);
        txtCategory = view.findViewById(R.id.txtCategoryDetailCake);
        txtPrice = view.findViewById(R.id.txtPriceDetailCake);
        txtQuantity = view.findViewById(R.id.txtAmountDetailCake);

        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getCake().observe(getViewLifecycleOwner(), new Observer<Cake>() {
            @Override
            public void onChanged(Cake cake) {
                cakeDetail = cake;
            }
        });
        cakeDetail = shopViewModel.getCake().getValue();
        setTextDetailCake();

    }

    private void setTextDetailCake() {
        int quantity = 1;
        float price = cakeDetail.getPrice();
        txtNameCake.setText(cakeDetail.getName());
        txtCategory.setText(cakeDetail.getCategory().getName());
        txtPrice.setText(String.valueOf(quantity * price));
        txtQuantity.setText(String.valueOf(quantity));
    }
}
