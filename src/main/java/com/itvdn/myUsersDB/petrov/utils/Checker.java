package com.itvdn.myUsersDB.petrov.utils;

import com.itvdn.myUsersDB.petrov.application.Config;
import com.itvdn.myUsersDB.petrov.user.User;
import com.itvdn.myUsersDB.petrov.user.form.UserForm;

import java.util.Objects;

public class Checker {
    private static boolean isCorrectFilled(Object field, boolean isSet, boolean isRequired) {
        return (field != null || !isRequired) && isSet;
    }

    private static boolean isCorrectLength(String field, int minValue, int maxValue) {
        return field != null && field.length() >= minValue && field.length() <= maxValue;
    }

    public static boolean checkFirstName(UserForm userForm) {
        return isCorrectFilled(userForm.getFirstName(), userForm.isFirstNameSet(), Config.getInstance().REQUIRED_USER_FIRST_NAME);
    }

    public static boolean checkLastName(UserForm userForm) {
        return isCorrectFilled(userForm.getLastName(), userForm.isLastNameSet(), Config.getInstance().REQUIRED_USER_LAST_NAME);
    }

    public static boolean checkBirthday(UserForm userForm) {
        return isCorrectFilled(userForm.getBirthday(), userForm.isBirthdaySet(), Config.getInstance().REQUIRED_USER_BIRTHDAY);
    }

    public static boolean checkEmail(UserForm userForm) {
        return isCorrectFilled(userForm.getEmail(), userForm.isEmailSet(), Config.getInstance().REQUIRED_USER_EMAIL);
    }

    public static boolean checkLogin(UserForm userForm) {
        Config config = Config.getInstance();
        return isCorrectLength(userForm.getLogin(), config.MIN_LENGTH_USER_LOGIN, config.MAX_LENGTH_USER_LOGIN);
    }

    public static boolean checkPassword(UserForm userForm) {
        Config config = Config.getInstance();
        return isCorrectLength(userForm.getPassword(), config.MIN_LENGTH_USER_PASSWORD, config.MAX_LENGTH_USER_PASSWORD);
    }

    public static boolean checkNewPassword(UserForm userForm) {
        Config config = Config.getInstance();
        return isCorrectLength(userForm.getNewPassword(), config.MIN_LENGTH_USER_PASSWORD, config.MAX_LENGTH_USER_PASSWORD);
    }

    public static boolean checkSecretQuestion(UserForm userForm) {
        return isCorrectFilled(userForm.getSecretQuestion(), userForm.isSecretQuestionSet(), Config.getInstance().REQUIRED_USER_SECRET);
    }

    public static boolean checkSecretAnswer(UserForm userForm) {
        return isCorrectFilled(userForm.getSecretAnswer(), userForm.isSecretAnswerSet(), Config.getInstance().REQUIRED_USER_SECRET);
    }

    private static boolean recoveryCheck(UserForm userForm, User userFromDB) {
        Config config = Config.getInstance();
        boolean firstNameEquals = Objects.equals(userForm.getFirstName(), userFromDB.getUserData().getFirstName());
        boolean lastNameEquals = Objects.equals(userForm.getLastName(), userFromDB.getUserData().getLastName());
        boolean birthdayEquals = Objects.equals(userForm.getBirthday(), userFromDB.getUserData().getBirthday());
        boolean emailEquals = Objects.equals(userForm.getEmail(), userFromDB.getUserData().getEmail());
        boolean loginEquals = Objects.equals(userForm.getLogin(), userFromDB.getAuthentication().getLogin());
        boolean secretQuestionEquals = Objects.equals(userForm.getSecretQuestion(), userFromDB.getSecret().getQuestion());
        boolean secretAnswerEquals = Objects.equals(userForm.getSecretAnswer(), userFromDB.getSecret().getAnswer());
        return (firstNameEquals ? config.PERCENT_CORRECT_USER_FIRST_NAME : config.ZERO) +
                (lastNameEquals ? config.PERCENT_CORRECT_USER_LAST_NAME : config.ZERO) +
                (birthdayEquals ? config.PERCENT_CORRECT_USER_BIRTHDAY : config.ZERO) +
                (emailEquals ? config.PERCENT_CORRECT_USER_EMAIL : config.ZERO) +
                (loginEquals ? config.PERCENT_CORRECT_USER_LOGIN : config.ZERO) +
                (secretQuestionEquals ? config.PERCENT_CORRECT_USER_SECRET_QUESTION : config.ZERO) +
                (secretAnswerEquals ? config.PERCENT_CORRECT_USER_SECRET_ANSWER : config.ZERO) >= config.PERCENT_CORRECT_USER_DATA_TOTAL;
    }

    public static boolean registrationCheck(UserForm userForm) {
        return userForm != null &&
                checkFirstName(userForm) &&
                checkLastName(userForm) &&
                checkBirthday(userForm) &&
                checkEmail(userForm) &&
                checkLogin(userForm) &&
                checkPassword(userForm) &&
                checkSecretQuestion(userForm) &&
                checkSecretAnswer(userForm);
    }

    public static boolean changePasswordCheck(UserForm userForm, User userFromDB) {
        return userForm != null &&
                userFromDB != null &&
                recoveryCheck(userForm, userFromDB);
    }

    public static boolean authenticationCheck(UserForm userForm, User userFromDB) {
        return userForm != null &&
                userFromDB != null &&
                Objects.equals(userForm.getLogin(), userFromDB.getAuthentication().getLogin()) &&
                Objects.equals(userForm.getPassword(), Encryptor.decrypt(userFromDB.getAuthentication().getPassword()));
    }
}
