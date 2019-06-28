package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import app.entity.Certificate;
import app.utilities.Database;

/**
 * @file CertificateDao.java
 * @brief Klasa do wprowadzania  i pobierania zwolnienień do bazy danych.
 * @details CertificateDao.java służy do komunikacji z bazą danych, wprowadzania do niej informacji dotyczących zwolnień lekarskich obsługiwanego pacjenta i ich pobierania.
 */
public class CertificateDao {

    /**
     * @param certificate Zwolnienie pacjenta
     * @return Metoda zwraca true gdy dodanie zwolnienia do bazy powiedzie się, a false gdy informacje o zwolnieniu znajdują się już w bazie.
     * @details Metoda setCertificate() wprowadza do bazy informacje o podanym zwolnieniu lekarskim,
     * a nasetępnie zwraca wartość typu boolean w zależności od wyniku przeprowadzonej operacji.
     */
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

    /**
     * @param userId Id użytkownika
     * @return Metoda zwraca listę typu ArrayList zawierającą zwolnienia pacjęta o podanym id. W przypadku gdy id pacjęta ma wartość null.
     * @throws SQLException
     * @details Metoda getCertificates() szuka pacjenta o wprowadzonym id lub wszystkich pacjentów w przypadku wartości null, a następnie zwraca listę ich zwolnień.
     */
    public ArrayList<Certificate> getCertificates(Integer userId) throws SQLException {
        ArrayList<Certificate> certificates = new ArrayList<>();

        String sql = "SELECT * FROM patients";

        if(userId != null) {
            sql += " WHERE user_id=" + userId;
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