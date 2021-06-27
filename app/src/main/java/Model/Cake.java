package Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Cake {
    @SerializedName("id")
    private Integer id;
    private String name;
    private CategoryCake category;
    private Float price;
    private Float discount;
    private Integer amount;
    private String avatar;

    public Cake(Integer id, String name, CategoryCake category, Float price, Float discount, Integer amount, String avatar) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.amount = amount;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryCake getCategory() {
        return category;
    }

    public void setCategory(CategoryCake category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", discount=" + discount +
                ", amount=" + amount +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return getId().equals(cake.getId()) &&
                getName().equals(cake.getName()) &&
                getCategory().equals(cake.getCategory()) &&
                getPrice().equals(cake.getPrice()) &&
                Objects.equals(getDiscount(), cake.getDiscount()) &&
                getAmount().equals(cake.getAmount()) &&
                Objects.equals(getAvatar(), cake.getAvatar());
    }

    public static DiffUtil.ItemCallback<Cake> itemCallback = new DiffUtil.ItemCallback<Cake>() {
        @Override
        public boolean areItemsTheSame(@NonNull Cake oldItem, @NonNull Cake newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Cake oldItem, @NonNull Cake newItem) {
            return oldItem.equals(newItem);
        }
    };

}
