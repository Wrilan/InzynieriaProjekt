package app.dao;

import app.entity.Patient;
import app.utilities.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class PatientDao {
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