package app.entity;

import java.io.Serializable;

public class User implements Serializable {

    public int id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String password;

    private int role;

    public User() {
        this.firstName = "TEST";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRole() {
        return this.role;
    }
}