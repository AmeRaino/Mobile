package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.R;

public class CakeListAdapter  extends RecyclerView.Adapter<CakeListAdapter.myviewholder> {

//    private Context context;
    //private ArrayList<Category> categoriesLists;

//    public CakeListAdapter(Context context) {
//        this.context = context;
//        //        this.categoriesLists = categoryList;
//    }

    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cake_list_item, parent, false);
        return new CakeListAdapter.myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
//            Category category = categoriesLists.get(position);
//            holder.txtNameCategory.setText(category.getNameCategory());
//            Picasso.get().
//            load(category.getImgCategory()).
//            fit().centerCrop().
//            into(holder.imgCategory);
        holder.cakeListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                NavController navController = Navigation.findNavController(activity, R.id.host_fragment);
                navController.navigate(R.id.action_cakeListFragment_to_cakeDetailFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class myviewholder extends RecyclerView.ViewHolder {

//        TextView txtNameCategory;
//        ImageView imgCategory;
        LinearLayout cakeListItem;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
//            txtNameCategory = itemView.findViewById(R.id.txtCakeCategory);
//            imgCategory = itemView.findViewById(R.id.imgCategory);
            cakeListItem = itemView.findViewById(R.id.cakeListItem);
        }
    }
}
