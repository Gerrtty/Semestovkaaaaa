package some_usefull_classes;

public class Address {

    private String town;
    private String district;
    private String street;
    private int number;

    public Address() {

    }

    public Address(String town, String  district, String street, int number) {
        this.town = town;
        this.district = district;
        this.street = street;
        this.number = number;
    }

    public String getTown() {
        return town;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
