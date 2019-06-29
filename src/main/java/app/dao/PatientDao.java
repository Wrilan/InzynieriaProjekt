package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import app.entity.Patient;
import app.utilities.Database;
/**
 * @file PatientDao.java
 * @brief Klasa do pobierania pacjenta z bazy danych.
 * @details PatientDao.java służy do komunikacji z bazą danych i wyciągania z niej informacji o pacjentach.
 */
public class PatientDao {
    /**
     * @param id Id pacjenta
     * @return Metoda zwraca instancję klasy Patient z danymi znalezionego pacjenta lub null w przypadku gdy pacjent o podanym id nie znajduje się w bazie danych.
     * @throws SQLException
     * @details Metoda getPatient() sprawdza, czy w bazie danych znajduje się pacjent o podanym id.
     * Jeśli pacjent zostanie znaleziony to zwraca go w postaci instancji klasy Patient
     * a jeśli nie, to metoda zwraca wartość null.
     */
    public Patient getPatient(int id) throws SQLException {
        ResultSet result = Database.Zus.query("SELECT * FROM patients WHERE id=" + id);

        while (Objects.requireNonNull(result).next()) {
            return new Patient(result.getInt("id"), result.getString("full_name"), result.getString("phone"),
                               result.getString("date_birth"), result.getString("pesel"), result.getString("nip"));
        }

        return null;
    }
    /**
     * @return Metoda zwraca listę (ArrayList) wszystkich pacjentów znajdujących się w bazie danych.
     * @throws SQLException
     * @details Metoda getPatients() przeszukuje bazę danych a następnie zwraca wszystkich znajdujących się w niej pacjentów.
     */
    public ArrayList<Patient> getPatients() throws SQLException {
        ArrayList<Patient> patients = new ArrayList<>();

        ResultSet result = Database.Zus.query("SELECT * FROM patients");

        while (Objects.requireNonNull(result).next()) {
            patients.add(new Patient(result.getInt("id"), result.getString("full_name"), result.getString("phone"),
                                     result.getString("date_birth"), result.getString("pesel"), result.getString("nip")));
        }

        return patients;
    }
}