package Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class CategoryCake {
    private String id;
    private String name;

    public CategoryCake(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryCake{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryCake that = (CategoryCake) o;
        return getId().equals(that.getId()) &&
                getName().equals(that.getName());
    }

    public static DiffUtil.ItemCallback<CategoryCake> itemCallback = new DiffUtil.ItemCallback<CategoryCake>() {
        @Override
        public boolean areItemsTheSame(@NonNull CategoryCake oldItem, @NonNull CategoryCake newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull CategoryCake oldItem, @NonNull CategoryCake newItem) {
            return oldItem.equals(newItem);
        }
    };

}
