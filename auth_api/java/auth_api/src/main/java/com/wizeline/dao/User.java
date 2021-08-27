package com.wizeline.dao;

public class User {
    private String username;
    private String password;
    private String salt;
    private String role;

    /**
     * @param username
     * @param password
     * @param salt
     * @param role
     */
    public User(String username, String password, String salt, String role) {
        super();
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getRole() {
        return role;
    }
}
