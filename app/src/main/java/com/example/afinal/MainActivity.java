package com.example.afinal;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import Model.CartItem;
import ViewModel.ShopViewModel;

public class MainActivity extends AppCompatActivity {

//    Toolbar customToolbar;
//    ViewPager2 vpBestSeller;
//    RecyclerView rclCakeCategory;
//    BestSellerAdapter bestSellerAdapter;
//    CakeCategoryApdapter cakeCategoryApdapter;
//    CartAdapter cartAdapter;
//    RecyclerView rclCartCake;
//    ArrayList<Cake> cakeList;
//    RecyclerView rclCakeCategoryList;
//    CakeCategoryListAdapter cakeCategoryListAdapter;
//    ShowRoomCakeAdapter showRoomCakeAdapter;
    ShopViewModel shopViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        shopViewModel.getCart().observe(this, new Observer<List<CartItem>>() {
            @Override
            public void onChanged(List<CartItem> cartItems) {
                Log.e("Cart", "onChanged: " + cartItems.size());
            }
        });
//        customToolbar = findViewById(R.id.tbr);
//        setSupportActionBar(customToolbar);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayShowTitleEnabled(false);
//            actionBar.setDisplayShowHomeEnabled(false);
//        }

//        cakeList = new ArrayList<>();
//        cakeList.add(new Cake("Sweety Donut",
//                "....",
//                "$19",
//                "Special Season",
//                "Sweet",
//                true,
//                R.drawable._donut)); cakeList.add(new Cake("Sweety Donut",
//                "....",
//                "$19",
//                "Special Season",
//                "Sweet",
//                true,
//                R.drawable._donut)); cakeList.add(new Cake("Sweety Donut",
//                "....",
//                "$19",
//                "Special Season",
//                "Sweet",
//                true,
//                R.drawable._donut)); cakeList.add(new Cake("Sweety Donut",
//                "....",
//                "$19",
//                "Special Season",
//                "Sweet",
//                true,
//                R.drawable._donut)); cakeList.add(new Cake("Sweety Donut",
//                "....",
//                "$19",
//                "Special Season",
//                "Sweet",
//                true,
//                R.drawable._donut)); cakeList.add(new Cake("Sweety Donut",
//                "....",
//                "$19",
//                "Special Season",
//                "Sweet",
//                true,
//                R.drawable._donut));
//
//
//        showRoomCakeAdapter = new ShowRoomCakeAdapter(vpBestSeller);
//        vpBestSeller = findViewById(R.id.vpBestSeller);
//        vpBestSeller.setAdapter(showRoomCakeAdapter);
//        vpBestSeller.setClipToPadding(false);
//        vpBestSeller.setClipChildren(false);
//        vpBestSeller.setOffscreenPageLimit(3);
//        vpBestSeller.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
//
//        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//                float r = 1 - Math.abs(position);
//                page.setScaleY(0.85f + r * 0.15f);
//            }
//        });
//        vpBestSeller.setPageTransformer(compositePageTransformer);
//        bestSellerAdapter = new BestSellerAdapter(this, cakeList);
//        vpBestSeller = findViewById(R.id.vpBestSeller);
//        vpBestSeller.setAdapter(bestSellerAdapter);
//        vpBestSeller.setFocusable(false);
//        vpBestSeller.setNestedScrollingEnabled(false);
//
//        ArrayList<Category> categoryList = new ArrayList<>();
//        rclCakeCategory = findViewById(R.id.rclCakeCategory);
//
//        categoryList.add(new Category("Doonut", R.drawable._donut_category, "123"));
//        categoryList.add(new Category("Doonut", R.drawable._donut_category, "123"));
//        categoryList.add(new Category("Doonut", R.drawable._donut_category, "123"));
//        categoryList.add(new Category("Doonut", R.drawable._donut_category, "123"));
//        categoryList.add(new Category("Doonut", R.drawable._donut_category, "123"));
//        categoryList.add(new Category("Doonut", R.drawable._donut_category, "123"));
//        categoryList.add(new Category("Doonut", R.drawable._donut_category, "123"));
//
//        cakeCategoryApdapter = new CakeCategoryApdapter(categoryList);
//        rclCakeCategory.setAdapter(cakeCategoryApdapter);
//        rclCakeCategory.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));
//        rclCakeCategory.setFocusable(false);
//        rclCakeCategory.setNestedScrollingEnabled(false);


//        cartAdapter = new CartAdapter(this);
//        rclCartCake = findViewById(R.id.rclCartCake);
//        rclCartCake.setAdapter(cartAdapter);
//        rclCartCake.setLayoutManager(new LinearLayoutManager(this));
//        rclCartCake.setFocusable(false);
//        rclCartCake.setNestedScrollingEnabled(false);

//        cakeCategoryListAdapter = new CakeCategoryListAdapter(this);
//        rclCakeCategoryList = findViewById(R.id.rclListCakeCategory);
//        rclCakeCategoryList.setAdapter(cakeCategoryListAdapter);
//        rclCakeCategoryList.setLayoutManager(new LinearLayoutManager(this));
//        rclCakeCategoryList.setFocusable(false);
//        rclCakeCategoryList.setNestedScrollingEnabled(false);


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu,menu);
//        return true;
//    }
}