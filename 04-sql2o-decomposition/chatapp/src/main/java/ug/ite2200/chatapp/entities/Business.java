package ug.ite2200.chatapp.entities;


public class Business extends User {

    private String characteristics;

    public Business(String email, String contact_number, String address, String name, String characteristics) {
        super(email, contact_number, address, name);
        this.characteristics = characteristics;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
}
