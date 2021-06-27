package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.R;
import com.ornach.nobobutton.NoboButton;

import java.util.ArrayList;

import Model.CartItem;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.myviewholder> {

    private ArrayList<CartItem> cartItems;
    private CartInterface cartInterface;

    public CartAdapter(ArrayList<CartItem> cartItems, CartInterface cartInterface) {
        this.cartItems = cartItems;
        this.cartInterface = cartInterface;
    }

    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_cakes, parent, false);
            return new CartAdapter.myviewholder(itemView);
            }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        CartItem cartItem = cartItems.get(position);
        holder.txtNameCategory.setText(cartItem.getCake().getCategory().getName());
        holder.txtNameCake.setText(cartItem.getCake().getName());
        holder.txtPrice.setText(String.valueOf(cartItem.getCake().getPrice() * cartItem.getQuantity()));
        holder.txtQuantity.setText(cartItem.getQuantity().toString());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartItems.remove(cartItem);
                cartInterface.deleteItem(cartItem);
            }
        });

        holder.btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.valueOf(holder.txtQuantity.getText().toString());
                if ( quantity - 1 > 0 ) {
                    quantity = quantity - 1;
                    cartInterface.changeQuantity(cartItem, quantity);
                    CartItem updatedItem = new CartItem(cartItem.getCake(), quantity);
                    cartItems.set(cartItems.indexOf(cartItem), updatedItem);
                }
            }
        });

        holder.btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.valueOf(holder.txtQuantity.getText().toString()) + 1;
                cartInterface.changeQuantity(cartItem, quantity);
                CartItem updatedItem = new CartItem(cartItem.getCake(), quantity);
                cartItems.set(cartItems.indexOf(cartItem), updatedItem);
            }
        });
//            Picasso.get().
//            load(category.getImgCategory()).
//            fit().centerCrop().
//            into(holder.imgCategory);
    }

    @Override
    public int getItemCount() {
            return cartItems.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView txtNameCategory;
        TextView txtNameCake;
        TextView txtPrice;
        TextView txtQuantity;
        NoboButton btnDelete;
        NoboButton btnIncrease;
        NoboButton btnDecrease;
        NoboButton btnOrder;
//        ImageView imgCategory;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            txtNameCategory = itemView.findViewById(R.id.txtCategory);
            txtNameCake = itemView.findViewById(R.id.txtNameCake);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtQuantity = itemView.findViewById(R.id.txtQuantity);
            btnDelete = itemView.findViewById(R.id.btnDeleteItemCart);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);
//            imgCategory = itemView.findViewById(R.id.imgCategory);
        }
    }

    public interface CartInterface {
        void deleteItem(CartItem cartItem);
        void changeQuantity(CartItem cartItem, int quantity);
    }
}
