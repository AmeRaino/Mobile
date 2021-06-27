package Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Order {
    private String id;
    private Long CreatedDate;
    private Float total;
    private String idCustomer;
    private String ShippingAddress;

    public Order(String id, Long createdDate, Float total, String idCustomer, String shippingAddress) {
        this.id = id;
        CreatedDate = createdDate;
        this.total = total;
        this.idCustomer = idCustomer;
        ShippingAddress = shippingAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Long createdDate) {
        CreatedDate = createdDate;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", CreatedDate=" + CreatedDate +
                ", total=" + total +
                ", idCustomer='" + idCustomer + '\'' +
                ", ShippingAddress='" + ShippingAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getId().equals(order.getId()) &&
                getCreatedDate().equals(order.getCreatedDate()) &&
                getTotal().equals(order.getTotal()) &&
                getIdCustomer().equals(order.getIdCustomer()) &&
                Objects.equals(getShippingAddress(), order.getShippingAddress());
    }

    public static DiffUtil.ItemCallback<Order> itemCallback = new DiffUtil.ItemCallback<Order>() {
        @Override
        public boolean areItemsTheSame(@NonNull Order oldItem, @NonNull Order newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Order oldItem, @NonNull Order newItem) {
            return oldItem.equals(newItem);
        }
    };
}
