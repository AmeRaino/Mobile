package Model;

public class Address {
    private String fullName;
    private String phone;
    private String City;
    private String ward;
    private String province;
    private String addressDetail;

    public Address() {}

    public Address(String fullName, String phone, String city, String ward, String province, String addressDetail) {
        this.fullName = fullName;
        this.phone = phone;
        City = city;
        this.ward = ward;
        this.province = province;
        this.addressDetail = addressDetail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    @Override
    public String toString() {
        return "Address{" +
                "fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", City='" + City + '\'' +
                ", ward='" + ward + '\'' +
                ", province='" + province + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                '}';
    }
}
