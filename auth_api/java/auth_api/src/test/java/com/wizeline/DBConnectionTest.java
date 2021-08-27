package com.wizeline;

import java.sql.SQLException;
import java.util.List;

import com.wizeline.dao.User;

import junit.framework.TestCase;

public class DBConnectionTest extends TestCase {

    public void testConection() throws SQLException {
        DBConnection connection = new DBConnection();
        List<User> users = connection.getUsers();
        assertFalse(users.isEmpty());
    }
}
