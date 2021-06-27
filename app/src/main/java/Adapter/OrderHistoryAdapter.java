package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.R;

import Dto.OrderDetailDto;

public class OrderHistoryAdapter extends ListAdapter<OrderDetailDto, OrderHistoryAdapter.myviewholder> {

    private RecyclerView rclOrderCakeHistory;
    private OrderCakesHistoryAdapter orderCakesHistoryAdapter;

    public OrderHistoryAdapter() {
        super(OrderDetailDto.itemCallback);
    }

    @Override
    public OrderHistoryAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_history_item, parent, false);

        rclOrderCakeHistory = itemView.findViewById(R.id.rclOrderCakeHistory);

        return new OrderHistoryAdapter.myviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistoryAdapter.myviewholder holder, int position) {
        OrderDetailDto orderDetailDto = getCurrentList().get(position);

        orderCakesHistoryAdapter = new OrderCakesHistoryAdapter(orderDetailDto.getCakes());
        rclOrderCakeHistory.setAdapter(orderCakesHistoryAdapter);
        rclOrderCakeHistory.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        rclOrderCakeHistory.setFocusable(false);
        rclOrderCakeHistory.setNestedScrollingEnabled(false);
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

//        private TextView txtCategory;
//        private TextView txtNameCake;
//        private TextView txtPrice;
//        private TextView txtQuantity;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
//            txtCategory = itemView.findViewById(R.id.txtCategory);
//            txtNameCake = itemView.findViewById(R.id.txtNameCake);
//            txtPrice = itemView.findViewById(R.id.txtPrice);
//            txtQuantity = itemView.findViewById(R.id.txtQuantity);
        }
    }

//    private int getSizeCakes() {
//        List<OrderDetailDto> orderDetailDtos = getCurrentList();
//        int count = 0;
//        for ( OrderDetailDto orderDetailDto: orderDetailDtos) {
//            count += orderDetailDto.getListOrder().size();
//        }
//        return count;
//    }

}
