package Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class CartItem {
    private Cake cake;
    private Integer quantity;

    public CartItem(Cake cake, Integer quantity) {
        this.cake = cake;
        this.quantity = quantity;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cake=" + cake +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return getCake().equals(cartItem.getCake()) &&
                getQuantity().equals(cartItem.getQuantity());
    }


    public static DiffUtil.ItemCallback<CartItem> itemCallback = new DiffUtil.ItemCallback<CartItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.getQuantity() == newItem.getQuantity();
        }

        @Override
        public boolean areContentsTheSame(@NonNull CartItem oldItem, @NonNull CartItem newItem) {
            return oldItem.equals(newItem);
        }
    };

}
