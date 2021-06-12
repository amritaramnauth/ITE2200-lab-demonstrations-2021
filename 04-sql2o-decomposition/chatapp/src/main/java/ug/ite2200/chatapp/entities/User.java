package ug.ite2200.chatapp.entities;

import java.util.UUID;

public class User {

    private UUID id;
    private String email;
    private String contact_number;
    private String address;
    private String username;

    private int age;
    private String gender;
    private String hobbies;

    private String characteristics;

    private UserType user_type;

    public User(String email, String contact_number, String address, String username, int age, String gender, String hobbies) {
        this.email = email;
        this.contact_number = contact_number;
        this.address = address;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
        this.user_type = UserType.PERSON;
    }
    public User(String email, String contact_number, String address, String username, String characteristics) {
        this.email = email;
        this.contact_number = contact_number;
        this.address = address;
        this.username = username;
        this.user_type = UserType.BUSINESS;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public UserType getUser_type() {
        return user_type;
    }

    public void setUser_type(UserType user_type) {
        this.user_type = user_type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", characteristics='" + characteristics + '\'' +
                ", user_type=" + user_type +
                '}';
    }
}
