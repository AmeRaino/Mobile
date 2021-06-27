package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.afinal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Model.Cake;

public class BestSellerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Cake> cakesLists;

    public BestSellerAdapter(Context context, ArrayList<Cake> cakesLists) {
        this.context = context;
        this.cakesLists = cakesLists;
    }

    @Override
    public int getCount() {
        return cakesLists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.showrom_cake, container, false);

        ImageView imgCake;
        TextView txtPriceCake, txtNameCake, txtDescCake;

//        imgCake = view.findViewById(R.id.imgShowroom);
//        txtNameCake = view.findViewById(R.id.txtShowroomCakeTitle);
//        txtDescCake = view.findViewById(R.id.txtDescCake);
//        txtPriceCake = view.findViewById(R.id.txtShowroomCakePrice);

        Cake cakeItem = cakesLists.get(position);
//        Picasso.get().
//                load(cakeItem.getImgCake()).
//                fit().centerCrop().
//                into(imgCake);
//        txtDescCake.setText(cakeItem.getDescCake());
//        txtNameCake.setText(cakeItem.getNameCake());
//        txtPriceCake.setText(cakeItem.getCakePrice());

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
