package com.itvdn.myUsersDB.petrov.exception;

public class EmailEmptyException extends Exception {
    public EmailEmptyException(String login) {
        super("Email for login '" + login + "' is empty");
    }
}
