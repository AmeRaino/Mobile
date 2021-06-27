package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.R;

import java.util.List;

import Dto.CakeDto;

public class OrderCakesHistoryAdapter extends RecyclerView.Adapter<OrderCakesHistoryAdapter.myviewholder> {

    private List<CakeDto> cakeDtoList;

    public OrderCakesHistoryAdapter(List<CakeDto> cakeDtoList) {
        this.cakeDtoList = cakeDtoList;
    }

    @Override
    public OrderCakesHistoryAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_cakes_history_item, parent, false);
        return new OrderCakesHistoryAdapter.myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderCakesHistoryAdapter.myviewholder holder, int position) {
        CakeDto cakeDto = cakeDtoList.get(position);
        holder.txtNameCake.setText(cakeDto.getName());
        holder.txtCategory.setText(cakeDto.getCategoryName());
        holder.txtPrice.setText("$" + String.valueOf(cakeDto.getPrice() * cakeDto.getQuantity()));
        holder.txtQuantity.setText("x" + cakeDto.getQuantity().toString());
    }

    @Override
    public int getItemCount() {
        return cakeDtoList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        private TextView txtCategory;
        private TextView txtNameCake;
        private TextView txtPrice;
        private TextView txtQuantity;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            txtCategory = itemView.findViewById(R.id.txtCategory);
            txtNameCake = itemView.findViewById(R.id.txtNameCake);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtQuantity = itemView.findViewById(R.id.txtQuantity);
        }
    }

}
