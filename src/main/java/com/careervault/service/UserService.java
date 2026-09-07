package com.careervault.service;

import com.careervault.dao.UserDAO;
import com.careervault.model.User;

import java.util.List;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public int addUser(User user) {
        return userDAO.addUser(user);
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public int deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }
}