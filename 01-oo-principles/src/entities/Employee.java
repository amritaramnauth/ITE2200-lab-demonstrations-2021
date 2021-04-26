package entities;

public class Employee {

    private String name;
    private String contactNumber;
    private String designation;

    public Employee(String name, String contactNumber, String designation) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
