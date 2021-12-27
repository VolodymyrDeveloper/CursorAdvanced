public class Address {
    private int id;
    private String address;
    private String city;
    private int phone;

    public Address(int id, String address, String city, int phone) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone=" + phone +
                '}';
    }
}
