package app.dao;

import app.utilities.Database;

public class UserDao {
    public void getUsers() {
        Database.query("SELECT * FROM users");


    }
}