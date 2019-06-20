package app.utilities;

import java.sql.*;
import java.util.Objects;

public class Database {
    private Database() {}

    public static class Nfz {
        private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        private static final String DB_URL = "jdbc:mysql://panel.vps100.nazwa.pl:3306/admin_nfz";
        private static final String USER = "admin_nfz";
        private static final String PASS = "Vg6H0No7PS";

        public static ResultSet query(String sql) {
            return Database.query(sql, Nfz.JDBC_DRIVER, Nfz.DB_URL, Nfz.USER, Nfz.PASS);
        }

        public static int update(String sql) {
            return Database.update(sql, Nfz.JDBC_DRIVER, Nfz.DB_URL, Nfz.USER, Nfz.PASS);
        }
    }

    public static class Zus {
        private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        private static final String DB_URL = "jdbc:mysql://panel.vps100.nazwa.pl:3306/admin_zus";
        private static final String USER = "admin_zus";
        private static final String PASS = "zg7GRgo7oS";

        public static ResultSet query(String sql) {
            return Database.query(sql, Zus.JDBC_DRIVER, Zus.DB_URL, Zus.USER, Zus.PASS);
        }

        public static int update(String sql) {
            return Database.update(sql, Zus.JDBC_DRIVER, Zus.DB_URL, Zus.USER, Zus.PASS);
        }
    }

    private static Statement getInstance(String JDBC_DRIVER, String DB_URL, String USER, String PASS) {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, USER, PASS).createStatement();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static ResultSet query(String sql, String JDBC_DRIVER, String DB_URL, String USER, String PASS) {
        try {
            return Objects.requireNonNull(Database.getInstance(JDBC_DRIVER, DB_URL, USER, PASS)).executeQuery(sql);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static int update(String sql, String JDBC_DRIVER, String DB_URL, String USER, String PASS) {
        try {
            return Objects.requireNonNull(Database.getInstance(JDBC_DRIVER, DB_URL, USER, PASS)).executeUpdate(sql);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}