package ba.unsa.etf.rs.projekat;

public class Address {
    private int id;
    private String street;
    private int number;
    private String postalCode;

    public Address() {}

    public Address(int id, String street, int number, String postalCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
