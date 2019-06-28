package app.entity;

import java.io.Serializable;
/**
 * @file Patient.java
 * @brief Klasa definiująca dane pacjenta.
 * @details Patient.java służy do obsługi danych pacjenta.
 */
public class Patient implements Serializable {

    private int id;
    private String fullName;
    private String phone;
    private String dateBirth;
    private String pesel;
    private String nip;
    /**
     * @param id Id pacjenta.
     * @param fullName Imię i Nazwisko pacjenta.
     * @param phone Numer telefonu.
     * @param dateBirth Data urodzenia pacjenta.
     * @param pesel Pesel pacjenta.
     * @param nip Nip miejsca zatrudnienia pacjenta.
     * @details Konstruktor klasy Patient.
     */
    public Patient(int id, String fullName, String phone, String dateBirth, String pesel, String nip) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.dateBirth = dateBirth;
        this.pesel = pesel;
        this.nip = nip;
    }

    /**
     * @param id Id pacjenta.
     * @details Metoda ustawia Id pacjenta na to zapewnione jako parametr metody.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return id - Id pacjenta.
     * @details Metoda zwraca id pacjenta.
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param fullName imię i nazwisko pacjenta.
     * @details Metoda ustawia imię i nazwisko pacjenta na to zapewnione jako parametr metody.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return fullName - Imię i nazwisko pacjenta.
     * @details Metoda zwraca wcześniej ustawione imię i nazwisko pacjenta.
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * @param phone Numer telefonu pacjenta.
     * @details Metoda ustawia numer telefonu pacjenta na ten zapewniony jako parametr metody.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return phone - Numer telefonu pacjenta.
     * @details Metoda zwraca numer telefonu pacjenta.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * @param dateBirth Data narodzin pacjenta.
     * @details Metoda ustawia date narodzin pacjenta na tą zapewnioną jako parametr metody.
     */
    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    /**
     * @return dateBirth - Data narodzin pacjenta.
     * @details Metoda zwraca datę narodzin pacjenta.
     */
    public String getDateBirth() {
        return this.dateBirth;
    }

    /**
     * @param pesel Pesel pacjenta.
     * @details Metoda ustawia pesel pacjenta na ten zapewniony jako parametr metody.
     */
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    /**
     * @return pesel - Pesel pacjenta.
     * @details Metoda zwraca pesel pacjenta.
     */
    public String getPesel() {
        return this.pesel;
    }

    /**
     * @param nip Nip miejsca zatrudnienia pacjenta.
     * @details Metoda ustawia nip miejsca zatrudnienia pacjenta na ten zapewniony jako parametr metody.
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

    /**
     * @return nip - Nip pacjenta.
     * @details Metoda zwraca nip miejsca zatrudnienia pacjenta.
     */
    public String getNip() {
        return this.nip;
    }
}