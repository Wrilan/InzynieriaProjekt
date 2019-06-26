package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import app.entity.User;
import app.utilities.Database;

public class UserDao {
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