package com.example.afinal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ornach.nobobutton.NoboButton;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import Adapter.CartAdapter;
import Api.OrderApi;
import Dto.OrderDto;
import Model.Address;
import Model.Cake;
import Model.CartItem;
import ViewModel.ShopViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartFragment extends Fragment implements CartAdapter.CartInterface {

    private ShopViewModel shopViewModel;
    private CartAdapter cartAdapter;
    private RecyclerView rclCartCake;
    private TextView txtTotalPrice;
    private ImageView btnEditAddress;
    private NoboButton btnOrder;
    private TextView txtAddress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart, container, false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        rclCartCake = view.findViewById(R.id.rclCartCake);
        txtTotalPrice = view.findViewById(R.id.txtTotalPrice);
        btnEditAddress = view.findViewById(R.id.btnEditAddress);
        btnOrder = view.findViewById(R.id.btnOrder);
        txtAddress = view.findViewById(R.id.txtAddress);

        ArrayList<CartItem> cartItems = new ArrayList<>(shopViewModel.getCart().getValue());
        cartAdapter = new CartAdapter(cartItems, this);
        rclCartCake.setAdapter(cartAdapter);
        rclCartCake.setLayoutManager(new LinearLayoutManager(getContext()));
        rclCartCake.setFocusable(false);
        rclCartCake.setNestedScrollingEnabled(false);

        setAddress();

        shopViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
                cartAdapter.notifyDataSetChanged();
            }
        });

        shopViewModel.getTotalPrice().observe(getViewLifecycleOwner(), new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                txtTotalPrice.setText(aDouble.toString());
            }
        });

        btnEditAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                NavController navController = Navigation.findNavController(activity, R.id.host_fragment);
                navController.navigate(R.id.action_cartFragment_to_fragmentShippingAddress);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Cake> cakes = new ArrayList<>();
                cakes = getCakes(shopViewModel.getCart().getValue());
                createOrder(cakes);
            }

        });
    }

    private ArrayList<Cake> getCakes(List<CartItem> cartItems) {
        ArrayList<Cake> cakes = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            cakes.add((cartItem.getCake()));
        }

        return cakes;
    }

    private void createOrder(ArrayList<Cake> cakes) {
        OrderDto orderDto = new OrderDto("guest",
                1620110775822L,
                100000f,
                txtAddress.getText().toString(),
                cakes );
        OrderApi.orderApi.createOrder(orderDto).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.e("ok", "ok");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("err", "err");
            }
        });
    }

    private void setAddress() {
        Address address = shopViewModel.getSaveAddress().getValue();
        if (address != null) {
            txtAddress.setText(address.getFullName() + " (" + address.getPhone() + ")\n"
                                + address.getProvince() + " " + address.getCity() + " " + address.getWard()
                                + "\n" + address.getAddressDetail());

            ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) txtAddress.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;;
            txtAddress.setLayoutParams(params);
        }
    }

    @Override
    public void deleteItem(CartItem cartItem) {
        shopViewModel.removeItemFromCart(cartItem);
    }

    @Override
    public void changeQuantity(CartItem cartItem, int quantity) {
        shopViewModel.changeQuantity(cartItem, quantity);
    }
}