package com.itvdn.myUsersDB.petrov.exception;

public class UserNotExistException extends Exception {
    public UserNotExistException(String login) {
        super("User with login '" + login + "' does not exist");
    }
}
