package com.wizeline;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.SecretKey;

import org.apache.commons.codec.digest.DigestUtils;

import com.wizeline.dao.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class Methods {
    public static String generateToken(String username, String password) throws SQLException {
        DBConnection connection = new DBConnection();
        List<User> users = connection.getUsers();
        SecretKey key = Keys.hmacShaKeyFor("my2w7wjd7yXF64FIADfJxNs1oupTGAuW".getBytes(StandardCharsets.UTF_8));
        Map<String,String> payload = new HashMap<String,String>();

        String token = "";
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (DigestUtils.sha512Hex(password + user.getSalt()).equals(user.getPassword())) {
                    payload.put("role", user.getRole());
                    token = Jwts.builder().setHeaderParam("alg", "HS256").setClaims(payload).signWith(key).setHeaderParam("typ", "JWT").compact();
                    break;
                }
            }
        }
        return token;
    }

    public static String accessData(String authorization) {
        return "test";
    }
}
