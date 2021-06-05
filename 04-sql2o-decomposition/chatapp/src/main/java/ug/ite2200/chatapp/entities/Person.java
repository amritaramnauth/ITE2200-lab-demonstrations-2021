package ug.ite2200.chatapp.entities;

public class Person extends  User {

    private int age;
    private String gender;
    private String hobbies;

    public Person(String email, String contact_number, String address, String name, int age, String gender, String hobbies) {
        super(email, contact_number, address, name);
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
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
}
