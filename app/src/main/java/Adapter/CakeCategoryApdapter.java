package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.R;

import Model.CategoryCake;

public class CakeCategoryApdapter  extends ListAdapter<CategoryCake, CakeCategoryApdapter.myviewholder> {

    public CakeCategoryApdapter() {
        super(CategoryCake.itemCallback);
    }

    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cake_category, parent, false);
        return new CakeCategoryApdapter.myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        CategoryCake category = getCurrentList().get(position);
        holder.txtNameCategory.setText(category.getName());
//        Picasso.get().
//                load(category.getImgCategory()).
//                fit().centerCrop().
//                into(holder.imgCategory);
        holder.cakeListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                NavController navController = Navigation.findNavController(activity, R.id.host_fragment);
                navController.navigate(R.id.action_homeFragment_to_cakeListFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView txtNameCategory;
        ImageView imgCategory;
        private CardView cakeListItem;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            txtNameCategory = itemView.findViewById(R.id.txtCakeCategory);
            imgCategory = itemView.findViewById(R.id.imgCategory);
            cakeListItem = itemView.findViewById(R.id.categoryItem);
        }
    }
}
