package com.itvdn.myUsersDB.petrov.user.form;

import com.itvdn.myUsersDB.petrov.application.Config;
import com.itvdn.myUsersDB.petrov.utils.Encryption;

import java.util.Date;

public class CheckUserForm {
    private static boolean checkRequiredField(Object field, boolean configValue) {
        return !(configValue && field == null);
    }

    private static boolean checkLengthOfField(String field, int minValue, int maxValue) {
        return field != null && field.length() >= minValue && field.length() <= maxValue;
    }

    private static boolean checkFirstName(String firstName) {
        return checkRequiredField(firstName, Config.getInstance().REQUIRED_USER_FIRST_NAME);
    }

    private static boolean checkLastName(String lastName) {
        return checkRequiredField(lastName, Config.getInstance().REQUIRED_USER_LAST_NAME);
    }

    private static boolean checkLogin(String login) {
        Config config = Config.getInstance();
        return checkLengthOfField(login, config.MIN_LENGTH_USER_LOGIN, config.MAX_LENGTH_USER_LOGIN);
    }

    private static boolean checkPassword(String password) {
        Config config = Config.getInstance();
        return checkLengthOfField(Encryption.decrypt(password), config.MIN_LENGTH_USER_PASSWORD, config.MAX_LENGTH_USER_PASSWORD);
    }

    private static boolean checkBirthday(Date birthday) {
        return checkRequiredField(birthday, Config.getInstance().REQUIRED_USER_BIRTHDAY);
    }

    private static boolean checkEmail(String email) {
        return checkRequiredField(email, Config.getInstance().REQUIRED_USER_EMAIL);
    }

    private static boolean checkSecret(String secret) {
        return checkRequiredField(secret, Config.getInstance().REQUIRED_USER_SECRET);
    }

    public static boolean registrationCheck(UserForm userForm) {
        return checkFirstName(userForm.getFirstName()) &&
                checkLastName(userForm.getLastName()) &&
                checkLogin(userForm.getLogin()) &&
                checkPassword(userForm.getPassword()) &&
                checkBirthday(userForm.getBirthday()) &&
                checkEmail(userForm.getEmail()) &&
                checkSecret(userForm.getSecretQuestion()) &&
                checkSecret(userForm.getSecretAnswer());
    }
}
