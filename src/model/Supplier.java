package model;
public class Supplier

{
    private int id;
    private String phonenumber;
    private String fullName;

    public Supplier(int id, String number, String fullname) {
        this.id = id;
        this.fullName = fullname;
        this.phonenumber = number;

    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullname) {
        this.fullName = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "Supplier{id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phonenumber + '\'' +
                '}';

    }

}