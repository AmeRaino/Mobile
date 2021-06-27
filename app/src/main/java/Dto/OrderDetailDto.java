package Dto;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

import Model.Order;

public class OrderDetailDto {
    private Order order;
    private List<CakeDto> cakes;

    public OrderDetailDto(Order order, List<CakeDto> cakes) {
        this.order = order;
        this.cakes = cakes;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<CakeDto> getCakes() {
        return cakes;
    }

    public void setCakes(List<CakeDto> cakes) {
        this.cakes = cakes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailDto that = (OrderDetailDto) o;
        return getOrder().equals(that.getOrder()) &&
                getCakes().equals(that.getCakes());
    }

    public static DiffUtil.ItemCallback<OrderDetailDto> itemCallback = new DiffUtil.ItemCallback<OrderDetailDto>() {
        @Override
        public boolean areItemsTheSame(@NonNull OrderDetailDto oldItem, @NonNull OrderDetailDto newItem) {
            return oldItem.getOrder().equals(newItem.getOrder());
        }

        @Override
        public boolean areContentsTheSame(@NonNull OrderDetailDto oldItem, @NonNull OrderDetailDto newItem) {
            return oldItem.equals(newItem);
        }
    };
}
