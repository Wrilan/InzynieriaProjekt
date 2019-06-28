package app.utilities;

import java.sql.*;
import java.util.Objects;

/**
 * @file Database.java
 * @brief Klasa zajmująca się połączeniem aplikacji z bazą danych.
 * @details Klasa zajmująca się połączeniem aplikacji z bazą danych i wykonywaniem do niej zapytań.
 */
public class Database {
    private Database() {}

    /**
     * @file Database.java
     * @brief Klasa zajmująca się połączeniem aplikacji z bazą danych NFZ.
     * @details Klasa zajmująca się połączeniem aplikacji z bazą danych NFZ i wykonywaniem do niej zapytań.
     */
    public static class Nfz {
        private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        private static final String DB_URL = "jdbc:mysql://panel.vps100.nazwa.pl:3306/admin_nfz";
        private static final String USER = "admin_nfz";
        private static final String PASS = "Vg6H0No7PS";

        /**
         * @param sql Zapewniony kod języka sql.
         * @return Wynik metody Database.query.
         * @details Metoda query() wykonuje medodę Database.query dla zapewnionego kodu sql i danych klasy Nfz.
         */
        public static ResultSet query(String sql) {
            return Database.query(sql, Nfz.JDBC_DRIVER, Nfz.DB_URL, Nfz.USER, Nfz.PASS);
        }

        /**
         * @param sql Zapewniony kod języka sql.
         * @return Wynik metody Database.update.
         * @details Metoda update() wykonuje medodę Database.update dla zapewnionego kodu sql i danych klasy Nfz.
         */
        public static int update(String sql) {
            return Database.update(sql, Nfz.JDBC_DRIVER, Nfz.DB_URL, Nfz.USER, Nfz.PASS);
        }
    }

    /**
     * @file Database.java
     * @brief Klasa zajmująca się połączeniem aplikacji z bazą danych ZUS.
     * @details Klasa zajmująca się połączeniem aplikacji z bazą danych ZUS i wykonywaniem do niej zapytań.
     */
    public static class Zus {
        private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        private static final String DB_URL = "jdbc:mysql://panel.vps100.nazwa.pl:3306/admin_zus";
        private static final String USER = "admin_zus";
        private static final String PASS = "zg7GRgo7oS";

        /**
         * @param sql Zapewniony kod języka sql.
         * @return Wynik metody Database.query.
         * @details Metoda query() wykonuje medodę Database.query dla zapewnionego kodu sql i danych klasy Zus.
         */
        public static ResultSet query(String sql) {
            return Database.query(sql, Zus.JDBC_DRIVER, Zus.DB_URL, Zus.USER, Zus.PASS);
        }

        /**
         * @param sql Zapewniony kod języka sql.
         * @return Wynik metody Database.update.
         * @details Metoda update() wykonuje medodę Database.update dla zapewnionego kodu sql i danych klasy Zus.
         */
        public static int update(String sql) {
            return Database.update(sql, Zus.JDBC_DRIVER, Zus.DB_URL, Zus.USER, Zus.PASS);
        }
    }

    /**
     * @param JDBC_DRIVER com.mysql.jdbc.Driver
     * @param DB_URL Adres URL
     * @param USER Nazwa użytkownika
     * @param PASS Hasło
     * @return Statement
     */
    private static Statement getInstance(String JDBC_DRIVER, String DB_URL, String USER, String PASS) {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, USER, PASS).createStatement();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param sql Zapewniony kod sql
     * @param JDBC_DRIVER com.mysql.jdbc.Driver
     * @param DB_URL Adres URL
     * @param USER Nazwa użytkownika
     * @param PASS Hasło
     * @return Wynik metody executeQuery lub null w przypadku nie powodzenia jej wykonania.
     * @details metoda ResultSet() wykonuje metode executeQuery.
     */
    private static ResultSet query(String sql, String JDBC_DRIVER, String DB_URL, String USER, String PASS) {
        try {
            return Objects.requireNonNull(Database.getInstance(JDBC_DRIVER, DB_URL, USER, PASS)).executeQuery(sql);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param sql Zapewniony kod sql
     * @param JDBC_DRIVER com.mysql.jdbc.Driver
     * @param DB_URL Adres URL
     * @param USER Nazwa użytkownika
     * @param PASS Hasło
     * @return Wynik metody executeUpdate lub 0 w przypadku niepowodzenia jej wykonania.
     * @details metoda ResultSet() wykonuje metode executeUpdate.
     */
    private static int update(String sql, String JDBC_DRIVER, String DB_URL, String USER, String PASS) {
        try {
            return Objects.requireNonNull(Database.getInstance(JDBC_DRIVER, DB_URL, USER, PASS)).executeUpdate(sql);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}