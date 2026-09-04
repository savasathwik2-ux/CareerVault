package com.careervault.dao;

import com.careervault.model.User;
import com.careervault.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for User-related database operations.
 *
 * This class handles communication between the application
 * and the users table in the CareerVault database.
 */
public class UserDAO {

    /**
     * Inserts a new user into the users table.
     *
     * @param user User object containing the user's details
     * @return number of rows inserted
     */
    public int addUser(User user) {

        String query = """
                INSERT INTO users
                (user_name, phone, email, linkedin, github)
                VALUES (?, ?, ?, ?, ?)
                """;



        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            // Set values according to the position of '?' in the SQL query
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getLinkedin());
            statement.setString(5, user.getGithub());

            // executeUpdate() returns the number of affected rows
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to add user", e);
        }
    }

    //Function to return User by USER_ID
    public User getUserById(int userId){
        String query = "SELECT * FROM users WHERE user_id = ?";
        User resultUser = null;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                resultUser = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("linkedin"),
                        resultSet.getString("github")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultUser;
    }
     //Function to return ALL the Users
    public List<User> getAllUsers() {

        String query = "SELECT * FROM users";

        List<User> users = new ArrayList<>();

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {

                User user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getString("linkedin"),
                        resultSet.getString("github")

                );

                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve users", e);
        }

        return users;
    }

    /**
     * Updates an existing user's details in the database.
     *
     * @param user User object containing the updated information
     * @return number of rows updated
     */
    public int updateUser(User user) {

        String query = """
            UPDATE users
            SET user_name = ?,
                phone = ?,
                email = ?,
                linkedin = ?,
                github = ?
            WHERE user_id = ?
            """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {

            // Set updated user details
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getLinkedin());
            statement.setString(5, user.getGithub());

            // Identify which user should be updated
            statement.setInt(6, user.getUserId());

            // executeUpdate() returns the number of affected rows
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update user", e);
        }
    }

    /**
     * Deletes a user from the database using their user ID.
     *
     * @param userId ID of the user to delete
     * @return number of rows deleted
     */
    public int deleteUser(int userId) {

        String query = """
            DELETE FROM users
            WHERE user_id = ?
            """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {

            // Set the ID of the user to be deleted
            statement.setInt(1, userId);

            // executeUpdate() returns the number of rows deleted
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete user", e);
        }
    }
}