package com.itvdn.myUsersDB.petrov.utils;

import com.itvdn.myUsersDB.petrov.exception.EmailEmptyException;
import com.itvdn.myUsersDB.petrov.user.User;

public class Mailer {
    private static void send(User user, String message) throws EmailEmptyException {
        if (user.getUserData().getEmail() != null) {
            // TODO for send
        } else {
            throw new EmailEmptyException(user.getAuthentication().getLogin());
        }
    }

    public static void sendUserData(User user) throws EmailEmptyException {
        send(user, user.getUserData().toString());
    }

    public static void sendSecretData(User user) throws EmailEmptyException {
        send(user, user.getSecret().toString());
    }
}
