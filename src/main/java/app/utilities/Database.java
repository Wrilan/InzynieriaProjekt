package app.utilities;

import java.sql.*;

public class Database {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://panel.vps100.nazwa.pl:3306/admin_nfz";

    private static final String USER = "admin_nfz";
    private static final String PASS = "Vg6H0No7PS";

    private Database() {}

    public static ResultSet query(String sql) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            return statement.executeQuery(sql);

        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static int update(String sql) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            return statement.executeUpdate(sql);

        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}