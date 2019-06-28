package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import app.entity.User;
import app.utilities.Database;

/**
 * @file UserDao.java
 * @brief Klasa do pobierania użytkownika z bazy danych.
 * @details UserDao.java służy do komunikacji z bazą danych i wyciągania z niej informacji o użytkownikach.
 */
public class UserDao {
    /**
     * @param techId Id użytkownika
     * @return Metoda zwraca instancję klasy User z danymi znalezionego użytkownika lub null w przypadku gdy użytkownik o podanym id nie znajduje się w bazie danych.
     * @throws SQLException
     * @details Metoda getUser() sprawdza, czy w bazie danych znajduje się użytkownik o podanym id.
     * Jeśli użytkownik  zostanie znaleziony to zwraca go w postaci instancji klasy User
     * a jeśli nie, to metoda zwraca wartość null.
     */
    public User getUser(int techId) throws SQLException {
        ResultSet result = Database.Nfz.query("SELECT * FROM users WHERE tech_id=" + techId);

        while (Objects.requireNonNull(result).next()) {
            return new User(result.getInt("id"), result.getInt("tech_id"),
                            result.getString("first_name"), result.getString("last_name"),
                            result.getString("phone"), result.getString("email"),
                            result.getString("password"), result.getInt("role"));
        }

        return null;
    }
}