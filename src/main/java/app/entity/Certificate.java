package app.entity;

import java.io.Serializable;
/**
 * @file Certificate.java
 * @brief Klasa definiująca dane wystawionego dokumentu.
 * @details Certificate.java służy do obsługi danych dokumentu.
 */
public class Certificate implements Serializable {

    private int id;
    private int patientId;
    private String dateRelease;
    private String dateFrom;
    private String dateTo;
    private int type;
    private int code;
    /**
     * @param id Id dokumentu
     * @param patientId Id pacjenta
     * @param dateRelease Data realizacji(wystawienia) dokumentu
     * @param dateFrom Data początku zwolnienia
     * @param dateTo Data zakończenia zwolnienia
     * @param type Typ zwolnienia
     * @param code Kod zwolnienia.
     * @details Konstruktor klasy Certificate
     */
    public Certificate(int id, int patientId, String dateRelease, String dateFrom, String dateTo, int type, int code) {
        this.id = id;
        this.patientId = patientId;
        this.dateRelease = dateRelease;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.type = type;
        this.code = code;
    }

    /**
     * @param id Id dokumentu.
     * @details Metoda ustawia ID dokumentu na to zapewnione jako parametr metody.
     */
    public void setId(int id) { this.id = id; }

    /**
     * @return id - Id dokumentu.
     * @details Metoda zwraca id dokumentu.
     */
    public int getId() { return this.id; }

    /**
     * @param userId Id pacjenta.
     * @details Metoda ustawia ID pacjenta na to zapewnione jako parametr metody.
     */
    public void setPatientId(int userId) { this.patientId = patientId; }

    /**
     * @return Metoda zwracająca id pacjenta.
     * @details Metoda zwraca id pacjenta.
     */
    public int setPatientId() { return this.patientId; }

    /**
     * @param dateRelease Data realizacji(wystawienia) dokumentu.
     * @details Metoda ustawia datę realizacji(wystawienia) dokumentu na datę wystawienia dokumentu.
     */
    public void setDateRelease(String dateRelease) { this.dateRelease = dateRelease; }

    /**
     * @return dateRelease - Data realizacji(wystawienia) dokumentu.
     * @details Metoda zwraca realizacji(wystawienia) dokumentu.
     */
    public String getDateRelease() { return this.dateRelease; }

    /**
     * @param dateFrom Data początku zwolnienia.
     *  @details Metoda ustawia datę początku zwolnienia na tą zapewnioną jako parametr metody.
     */
    public void setDateFrom(String dateFrom) { this.dateFrom = dateFrom; }

    /**
     * @return dateFrom - Datę początku zwolnienia.
     * @details Metoda zwraca datę początku zwolnienia.
     */
    public String getDateFrom() { return this.dateFrom; }

    /**
     * @param pesel Pesel użytkownika.
     * @details Metoda ustawia datę końca zwolnienia na tą zapewnioną jako parametr metody.
     */
    public void setDateTo(String pesel) { this.dateTo = dateTo; }

    /**
     * @return dateTo - Datę końca zwolnienia.
     * @details Metoda zwraca datę końca zwolnienia.
     */
    public String getDateTo() { return this.dateTo; }

    /**
     * @param type Typ zwolnienia.
     * @details Metoda ustawia typ zwolnienia na ten zapewniony jako parametr metody.
     */
    public void setType(int type) { this.type = type; }

    /**
     * @return type - Typ zwolnienia.
     * @details Metoda zwraca typ zwolnienia.
     */
    public int getType() { return this.type; }

    /**
     * @param code Kod zwolnienia.
     * @details Metoda ustawia kod zwolnienia na ten zapewniony jako parametr metody.
     */
    public void setCode(int code) { this.code = code; }

    /**
     * @return code - Kod zwolnienia.
     * @details Metoda zwraca kod zwolnienia.
     */
    public int getCode() { return this.code; }
}