package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import app.entity.Patient;
import app.utilities.Database;

public class PatientDao {
    public Patient getPatient(int id) throws SQLException {
        ResultSet result = Database.Zus.query("SELECT * FROM patients WHERE id=" + id);

        while (Objects.requireNonNull(result).next()) {
            return new Patient(result.getInt("id"), result.getString("full_name"), result.getString("phone"),
                               result.getString("date_birth"), result.getString("pesel"), result.getString("nip"));
        }

        return null;
    }

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