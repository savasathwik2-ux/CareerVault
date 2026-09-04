package com.careervault;

import com.careervault.dao.UserDAO;
import com.careervault.model.User;
import com.careervault.service.UserService;
import com.careervault.util.DBConnection;

import java.sql.Connection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User(
                "Sathwik",
                "9876543210",
                "sathwik@example.com",
                "https://linkedin.com/in/sathwik",
                "https://github.com/sathwik"
        );

        //Adding the New User
        int result = userService.addUser(user);

        if (result > 0) {
            System.out.println("User added successfully!");
        } else {
            System.out.println("Failed to add user.");
        }

        //Getting user By userId
        User foundUser = userService.getUserById(1);

        if (foundUser != null) {
            System.out.println("User found:");
            System.out.println(foundUser);
        } else {
            System.out.println("User not found.");
        }

        //Getting all the users
        List<User> users = userService.getAllUsers();

        System.out.println("All Users:");

        for (User currentUser : users) {
            System.out.println(currentUser);
        }

        //Updating User
        User updatedUser = new User(
                1,
                "Sathwik S",
                "9876543210",
                "sathwik@example.com",
                "https://linkedin.com/in/sathwik",
                "https://github.com/sathwik"
        );

        int updateResult = userService.updateUser(updatedUser);

        if (updateResult > 0) {
            System.out.println("User updated successfully!");
        } else {
            System.out.println("User not found.");
        }

        //Deleting User By UserId
        int deleteResult = userService.deleteUser(1);

        if (deleteResult > 0) {
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found.");
        }
    }
}
