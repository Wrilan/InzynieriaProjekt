package app.entity;

import java.io.Serializable;
/**
 * @file User.java
 * @brief Klasa definiująca użytkownika.
 * @details User.java służy do obsługi danych użytkownika.
 */
public class User implements Serializable {

    private int id;
    private int techId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private int role;
    /**
     * @param id Id użytkownika.
     * @param techId Id użytkownika.
     * @param firstName Imię użytkownika.
     * @param lastName Mazwisko użytkownika.
     * @param phone Numer telefonu użytkownika.
     * @param email Email użytkownika.
     * @param password Hasło użytkownika.
     * @param role Rola użytkownika.
     * @details Konstruktor klasy User.
     */
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
    /**
     * @param id Id użytkownika.
     * @details Metoda ustawia id użytkownika na to zapewnione jako parametr metody.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return id użytkownika.
     * @details Metoda zwraca techId użytkownika.
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param techId techId użytkownika.
     * @details Metoda ustawia techId użytkownika na to zapewnione jako parametr metody.
     */
    public void setTechId(int techId) {
        this.techId = techId;
    }

    /**
     * @return techId użytkownika.
     * @details Metoda zwraca techId użytkownika.
     */
    public int getTechId() {
        return this.techId;
    }

    /**
     * @param firstName Imię użytkownika.
     * @details Metoda ustawia imię użytkownika na to zapewnione jako parametr metody.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return firstName - Imię użytkownika.
     * @details Metoda zwraca imię użytkownika.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @param lastName Nazwisko użytkownika.
     * @details Metoda ustawia nazwisko użytkownika na to na to zapewnione jako parametr metody.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return lastName - Nazwisko użytkownika.
     * @details Metoda zwraca nazwisko użytkownika.
     */
    public String getLastName() { return this.lastName; }

    /**
     * @param phone Numer telefonu użytkownika.
     * @details Metoda ustawia numer telefonu użytkownika na ten zapewniony jako parametr metody.
     */
    public void setPhone(String phone) { this.phone = phone; }

    /**
     * @return phone - Numer telefonu użytkownika.
     * @details Metoda zwraca numer telefonu użytkownika.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * @param email Email użytkownika.
     * @details Metoda ustawia email użytkownika na ten zapewniony jako parametr metody.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return email - Email użytkownika.
     * @details Metoda zwraca email użytkownika.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param password Hasło użytkownika.
     * @details Metoda ustawia hasło użytkownika na to zapewnione jako parametr metody..
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return password - Hasło użytkownika.
     * @details Metoda zwraca hasło użytkownika.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param role Rola użytkownika.
     * @details Metoda ustawia rolę użytkownika na tą zapewnioną jako parametr metody.
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * @return role - Rola użytkownika.
     * @details Metoda zwraca rolę użytkownika.
     */
    public int getRole() {
        return this.role;
    }
}