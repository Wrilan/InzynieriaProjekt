package app.entity;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private int techId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private int role;

    public User(int id, int techId, String firstName, String lastName, String phone, String email, String password, int role) {
        this.id = id;
        this.techId = techId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setTechId(int techId) {
        this.techId = techId;
    }
    public int getTechId() {
        return this.techId;
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
    public String getLastName() { return this.lastName; }

    public void setPhone(String phone) { this.phone = phone; }
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