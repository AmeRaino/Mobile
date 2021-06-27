package com.example.afinal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.ornach.nobobutton.NoboButton;

import java.util.ArrayList;
import java.util.List;

import Adapter.BestSellerAdapter;
import Adapter.CakeCategoryApdapter;
import Adapter.ShowRoomCakeAdapter;
import Model.Cake;
import Model.CartItem;
import Model.Category;
import Model.CategoryCake;
import ViewModel.ShopViewModel;

public class HomeFragment extends Fragment implements ShowRoomCakeAdapter.RecyclerviewOnClickListener {
    View v;
    ViewPager2 vpBestSeller;
    RecyclerView rclCakeCategory;
    BestSellerAdapter bestSellerAdapter;
    CakeCategoryApdapter cakeCategoryApdapter;
    RecyclerView rclCakeCategoryList;
    ShowRoomCakeAdapter showRoomCakeAdapter;
    ArrayList<Category> categoryList;
    NoboButton btnCart;
    NoboButton btnOrder;
    private ShopViewModel shopViewModel;
    private OnClickListener buttonAddCartClick, rowClick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);
        vpBestSeller = (ViewPager2) v.findViewById(R.id.vpBestSeller);
        rclCakeCategory = (RecyclerView) v.findViewById(R.id.rclCakeCategory);
        btnCart = (NoboButton) v.findViewById(R.id.btnCart);
        btnOrder = v.findViewById(R.id.btnOrder);

        loadShowRoomCake();
        loadCategories();

        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getCart().observe(getViewLifecycleOwner(), new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
                Log.e("Cart", "onChanged: " + cartItems.size());
            }
        });
        shopViewModel.getCakes().observe(getViewLifecycleOwner(), new Observer<List<Cake>>() {
            @Override
            public void onChanged(List<Cake> cakes) {
                showRoomCakeAdapter.submitList(cakes);
            }
        });
        shopViewModel.getCategories().observe(getViewLifecycleOwner(), new Observer<List<CategoryCake>>() {
            @Override
            public void onChanged(List<CategoryCake> categoryCakes) {
                cakeCategoryApdapter.submitList(categoryCakes);
            }
        });

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shopViewModel.getCart().getValue().isEmpty()) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    NavController navController = Navigation.findNavController(activity, R.id.host_fragment);
                    navController.navigate(R.id.action_homeFragment_to_fragmentContinueShopping);
                }
                else {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    NavController navController = Navigation.findNavController(activity, R.id.host_fragment);
                    navController.navigate(R.id.action_homeFragment_to_cartFragment);
                }
            }
        });

        btnOrder.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                NavController navController = Navigation.findNavController(activity, R.id.host_fragment);
                navController.navigate(R.id.action_homeFragment_to_fragmentOrderHistory);
            }
        });
    }

    private void loadShowRoomCake() {
        showRoomCakeAdapter = new ShowRoomCakeAdapter(vpBestSeller, this);
        vpBestSeller.setAdapter(showRoomCakeAdapter);
        vpBestSeller.setClipToPadding(false);
        vpBestSeller.setClipChildren(false);
        vpBestSeller.setOffscreenPageLimit(3);
        vpBestSeller.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        vpBestSeller.setPageTransformer(compositePageTransformer);
    }

    private void loadCategories() {
        cakeCategoryApdapter = new CakeCategoryApdapter();
        rclCakeCategory.setLayoutManager(new GridLayoutManager(getActivity(), 1, GridLayoutManager.HORIZONTAL, false));
        rclCakeCategory.setAdapter(cakeCategoryApdapter);
        rclCakeCategory.setFocusable(false);
        rclCakeCategory.setNestedScrollingEnabled(false);
    }

    @Override
    public void recyclerviewClick(Cake cake) {
        boolean isAdded = shopViewModel.addCakeToCart(cake);
        Log.e("gogogo", "addItems: " + cake.getName() + isAdded);
    }

    @Override
    public void itemClick(Cake cake) {
        shopViewModel.setCake(cake);
    }
}
