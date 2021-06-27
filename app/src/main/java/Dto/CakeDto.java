package Dto;

public class CakeDto {
    private String name;
    private String categoryName;
    private Float price;
    private Integer quantity;
    private String avatar;

    public CakeDto(String name, String categoryName, Float price, Integer quantity, String avatar) {
        this.name = name;
        this.categoryName = categoryName;
        this.price = price;
        this.quantity = quantity;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CakeDto cakeDto = (CakeDto) o;
        return getName().equals(cakeDto.getName()) &&
                getCategoryName().equals(cakeDto.getCategoryName()) &&
                getPrice().equals(cakeDto.getPrice()) &&
                getQuantity().equals(cakeDto.getQuantity()) &&
                getAvatar().equals(cakeDto.getAvatar());
    }
}
