package Model;

public class OrderDetail {
    private String id;
    private String idOrder;
    private Float price;
    private Integer amount;
    private Float total;

    public OrderDetail(String id, String idOrder, Float price, Integer amount, Float total) {
        this.id = id;
        this.idOrder = idOrder;
        this.price = price;
        this.amount = amount;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id='" + id + '\'' +
                ", idOrder='" + idOrder + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", total=" + total +
                '}';
    }
}
