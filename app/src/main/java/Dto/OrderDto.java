package Dto;

import java.util.List;

import Model.Cake;

public class OrderDto {
    private String idCustomer;
    private Long createdDate;
    private Float total;
    private String shippingAddress;
    private List<Cake> cakes;

    public OrderDto(String idCustomer, Long createdDate, Float total, String shippingAddress, List<Cake> cakes) {
        this.idCustomer = idCustomer;
        this.createdDate = createdDate;
        this.total = total;
        this.shippingAddress = shippingAddress;
        this.cakes = cakes;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(List<Cake> cakes) {
        this.cakes = cakes;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idCustomer='" + idCustomer + '\'' +
                ", total=" + total +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", cakes=" + cakes +
                '}';
    }
}
