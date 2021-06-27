package Adapter;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.afinal.R;
import com.ornach.nobobutton.NoboButton;

import Model.Cake;

public class ShowRoomCakeAdapter extends ListAdapter<Cake, ShowRoomCakeAdapter.myviewholder> {

    private ViewPager2 viewPager2;
    private Dialog dia;
    private OnClickListener buttonAddCartClick, rowClick;
    private RecyclerviewOnClickListener listener;

    public ShowRoomCakeAdapter(ViewPager2 viewPager2,
                               RecyclerviewOnClickListener listener) {
        super(Cake.itemCallback);
        this.viewPager2 = viewPager2;
        this.listener = listener;
    }

    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.showrom_cake, parent, false);
        return new myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        Cake cake = getCurrentList().get(position);
        holder.txtName.setText(cake.getName());
        holder.txtPrice.setText(cake.getPrice().toString());
        holder.btnAddCart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.recyclerviewClick(cake);
            }
        });
//        holder.btnAddCart.setOnClickListener(buttonAddCartClick);
//        holder.showRoom.setOnClickListener(rowClick);
//        Picasso.get().
//                load(category.getImgCategory()).
//                fit().centerCrop().
//                into(holder.imgCategory);

        holder.showRoom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.itemClick(cake);
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                NavController navController = Navigation.findNavController(activity, R.id.host_fragment);
                navController.navigate(R.id.action_homeFragment_to_cakeDetailFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        private TextView txtPrice;
        private TextView txtName;
//        ImageView imgCategory;
        NoboButton btnAddCart;
        LinearLayout showRoom;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            txtPrice = itemView.findViewById(R.id.txtShowroomCakePrice);
            txtName = itemView.findViewById(R.id.txtShowroomCakeName);
//            imgCategory = itemView.findViewById(R.id.imgCategory);
            btnAddCart = itemView.findViewById(R.id.btnAddCartShowroom);
            showRoom = itemView.findViewById(R.id.showRoom);
        }
    }

    public interface RecyclerviewOnClickListener{
        void recyclerviewClick(Cake cake);
        void itemClick(Cake cake);
    }

//    private void addCart(@NonNull myviewholder holder, Cake cake) {
//        holder.btnAddCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dia = new Dialog(v.getContext());
//                dia.setContentView(R.layout.dialog_added_cart);
//                dia.show();
//
//            }
//        });
//    }
}
