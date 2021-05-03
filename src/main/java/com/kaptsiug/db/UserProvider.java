package com.kaptsiug.db;

import com.kaptsiug.model.User;
import com.kaptsiug.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserProvider {
    private static final String MSG_USER_NOT_FOUND = "No entity with id: %d";
    private static final String QUERY_SELECT_ALL_USERS = "SELECT * FROM User;";
    public static final String QUERY_INSERT_USER = "INSERT INTO User (firstName,login,password,age) VALUES (?,?,?,?);";
    public static final String QUERY_DELETE_USER_BY_ID = "DELETE FROM User WHERE User.id = ?";
    public static final String QUERY_SELECT_BY_LOGIN_PASSWORD = "SELECT * FROM User WHERE User.login = ? AND User.password = ?";
    private static UserProvider provider;

    private UserProvider() {
    }

    public static UserProvider getProvider() {
        if (provider == null) {
            provider = new UserProvider();
        }
        return provider;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(QUERY_SELECT_ALL_USERS);) {
            while (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getInt("age"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(QUERY_INSERT_USER);) {
            pStatement.setString(1, user.getFirstName());
            pStatement.setString(2, user.getLogin());
            pStatement.setString(3, user.getPassword());
            pStatement.setInt(4, user.getAge());
            pStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUserByID(int id) throws SQLException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(QUERY_DELETE_USER_BY_ID);) {
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
        }
    }

    public User getUsersByLoginPassword(String login, String password) {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement pStatement = connection.prepareStatement(QUERY_SELECT_BY_LOGIN_PASSWORD);) {
            pStatement.setString(1, login);
            pStatement.setString(2, password);
            final ResultSet rs = pStatement.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getInt("age"));
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
