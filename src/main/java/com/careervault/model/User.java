package com.careervault.model;

/**
 * Represents a user in the CareerVault application.
 *
 * This class acts as a model for the users table
 * in the CareerVault database.
 */
public class User {

    private int userId;
    private String userName;
    private String phone;
    private String email;
    private String linkedin;
    private String github;

    // Default constructor
    public User() {
    }

    // Constructor used when retrieving an existing user from the database
    public User(int userId, String userName, String phone,
                String email, String linkedin, String github) {

        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.linkedin = linkedin;
        this.github = github;
    }

    // Constructor used when creating a new user
    // userId is generated automatically by MySQL
    public User(String userName, String phone,
                String email, String linkedin, String github) {

        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.linkedin = linkedin;
        this.github = github;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", github='" + github + '\'' +
                '}';
    }
}