package ba.unsa.etf.rs.projekat;

import java.time.LocalDate;

public class UserGuest extends User {
    private String phoneNumber;
    private String idCardNumber;
    private String bankcardNumber;
    private Address address;
    private int roomNumber;

    public UserGuest() { super(); }

    public UserGuest(int id, String name, String surname, String username, String password, String phoneNumber,
                     String idCardNumber, String bankcardNumber, int roomNumber) {
        super(id, name, surname, username, password);
        this.phoneNumber = phoneNumber;
        this.idCardNumber = idCardNumber;
        this.bankcardNumber = bankcardNumber;
        this.roomNumber = roomNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public void setBankcardNumber(String bankcardNumber) {
        this.bankcardNumber = bankcardNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
