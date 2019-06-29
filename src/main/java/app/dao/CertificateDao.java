package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import app.entity.Certificate;
import app.utilities.Database;

public class CertificateDao {
    public static boolean setCertificate(Certificate certificate) {
        boolean result = true;

        if(Database.Zus.update("INSERT INTO certificates (patient_id, date_release, date_from, date_to, type, code) " +
                                   "VALUES ('" + certificate.setPatientId() + "', '" + certificate.getDateRelease() + "', " +
                                   "'" + certificate.getDateFrom() + "', '" + certificate.getDateTo() + "', " +
                                   "'" + certificate.getType() + "', '" + certificate.getCode() + "')") == 0) {
            result = false;
        }

        return result;
    }

    public ArrayList<Certificate> getCertificates(Integer patientId) throws SQLException {
        ArrayList<Certificate> certificates = new ArrayList<>();

        String sql = "SELECT * FROM certificates";

        if(patientId != null) {
            sql += " WHERE patient_id=" + patientId;
        }

        ResultSet result = Database.Zus.query(sql);

        while (Objects.requireNonNull(result).next()) {
            certificates.add(new Certificate(result.getInt("id"), result.getInt("patient_id"),
                                             result.getString("date_release"), result.getString("date_from"),
                                             result.getString("date_to"), result.getInt("type"),
                                             result.getInt("code")));
        }

        return certificates;
    }
}