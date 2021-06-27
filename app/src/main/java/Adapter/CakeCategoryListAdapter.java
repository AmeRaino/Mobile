package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Model.Category;

public class CakeCategoryListAdapter  extends RecyclerView.Adapter<CakeCategoryListAdapter.myviewholder> {

    private Context context;

    public CakeCategoryListAdapter(Context context) {
        this.context = context;
//        this.categoriesLists = categoryList;
    }

    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.category_cake_list, parent, false);
        return new CakeCategoryListAdapter.myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.cakeListAdapter = new CakeListAdapter();
        holder.rclCakeList.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL,false));
        holder.rclCakeList.setAdapter(holder.cakeListAdapter);
//        Category category = categoriesLists.get(position);
//        holder.txtNameCategory.setText(category.getNameCategory());
//        Picasso.get().
//                load(category.getImgCategory()).
//                fit().centerCrop().
//                into(holder.imgCategory);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class myviewholder extends RecyclerView.ViewHolder {

//        TextView txtNameCategory;
//        ImageView imgCategory;
        RecyclerView rclCakeList;
        CakeListAdapter cakeListAdapter;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            rclCakeList = itemView.findViewById(R.id.rclCakeList);
//            txtNameCategory = itemView.findViewById(R.id.txtCakeCategory);
//            imgCategory = itemView.findViewById(R.id.imgCategory);
        }
    }
}

