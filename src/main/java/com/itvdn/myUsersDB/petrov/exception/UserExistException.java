package com.itvdn.myUsersDB.petrov.exception;

public class UserExistException extends Exception {
    public UserExistException(String login) {
        super("User with login '" + login + "' already exists");
    }
}
