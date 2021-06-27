package com.example.afinal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ornach.nobobutton.NoboButton;

import org.jetbrains.annotations.NotNull;

import Adapter.ShippingAddressAdapter;
import Model.Address;
import ViewModel.ShopViewModel;


public class FragmentShippingAddress extends Fragment implements ShippingAddressAdapter.AddressInterface {

    private ShopViewModel shopViewModel;
    private ShippingAddressAdapter shippingAddressAdapter;
    private RecyclerView rclShippingAddress;
    private NoboButton btnSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shipping_address, container, false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);

        btnSave = view.findViewById(R.id.btnSave);
        rclShippingAddress = view.findViewById(R.id.rclShippingAddress);

        Address address = new Address();
        if ( shopViewModel.getAddress().getValue() != null ) {
            address = shopViewModel.getAddress().getValue();
        }
        shippingAddressAdapter = new ShippingAddressAdapter(this, address);
        rclShippingAddress.setAdapter(shippingAddressAdapter);
        rclShippingAddress.setLayoutManager(new LinearLayoutManager(getContext()));
        rclShippingAddress.setFocusable(false);
        rclShippingAddress.setNestedScrollingEnabled(false);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopViewModel.setSaveAddress(shopViewModel.getAddress().getValue());
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                NavController navController = Navigation.findNavController(activity, R.id.host_fragment);
                navController.navigate(R.id.action_fragmentShippingAddress_to_cartFragment);
            }
        });
    }

    @Override
    public void changeAddress(String address, String type) {
        shopViewModel.changeAddress(address, type);
        Log.e("123", " " + shopViewModel.getAddress().getValue().toString());
    }
}