package app.entity;

import java.io.Serializable;

public class Patient implements Serializable {

    private int id;
    private String fullName;
    private String phone;
    private String dateBirth;
    private String pesel;
    private String nip;

    public Patient(int id, String fullName, String phone, String dateBirth, String pesel, String nip) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.dateBirth = dateBirth;
        this.pesel = pesel;
        this.nip = nip;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getFullName() {
        return this.fullName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return this.phone;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }
    public String getDateBirth() {
        return this.dateBirth;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
    public String getPesel() {
        return this.pesel;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    public String getNip() {
        return this.nip;
    }
}