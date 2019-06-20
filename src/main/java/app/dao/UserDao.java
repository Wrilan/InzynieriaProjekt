package app.dao;

import app.entity.User;
import app.utilities.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserDao {
    public User getUser(int id) throws SQLException {
        ResultSet result = Database.Nfz.query("SELECT * FROM users WHERE id=" + id);

        while (Objects.requireNonNull(result).next()) {
            return new User(result.getInt("id"), result.getString("first_name"), result.getString("last_name"),
                            result.getString("phone"), result.getString("email"), result.getString("password"),
                            result.getInt("role"));
        }

        return null;
    }
}