package com.itvdn.myUsersDB.petrov.utils;

import com.itvdn.myUsersDB.petrov.exception.EmailEmptyException;
import com.itvdn.myUsersDB.petrov.user.User;

public class Mailer {
    private static boolean checkEmail(User user) {
        return user.getUserData().getEmail() != null;
    }

    public static void sendUserData(User user) {
        String info = "Send user data for login '" + user.getAuthentication().getLogin() + "' ";
        if (checkEmail(user)) {
            String userInfo = "email: " +
                    "";
            // TODO for send
        } else {
            try {
                throw new EmailEmptyException();
            } catch (EmailEmptyException e) {
                e.printStackTrace();
            }
        }
    }
}
