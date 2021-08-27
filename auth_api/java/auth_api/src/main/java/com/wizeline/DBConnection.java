package com.wizeline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wizeline.dao.User;

public class DBConnection {
    Connection conn;

    private Connection getConnection() throws SQLException {
        if (null != conn) return conn;
        conn = DriverManager.getConnection("jdbc:mysql://bootcamp-tht.sre.wize.mx:3306/bootcamp_tht", "secret", "noPow3r");
        return conn;
    }

    public List<User> getUsers() throws SQLException{
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from users");
        List<User> users = new ArrayList<>();
        while(rs.next()) {
            users.add(new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        return users;
    }
}
