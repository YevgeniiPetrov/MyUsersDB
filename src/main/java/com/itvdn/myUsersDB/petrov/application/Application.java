package com.itvdn.myUsersDB.petrov.application;

import com.itvdn.myUsersDB.petrov.exception.EmailEmptyException;
import com.itvdn.myUsersDB.petrov.exception.UnsupportedAction;
import com.itvdn.myUsersDB.petrov.exception.UserExistException;
import com.itvdn.myUsersDB.petrov.exception.UserNotExistException;
import com.itvdn.myUsersDB.petrov.user.Authentication;
import com.itvdn.myUsersDB.petrov.user.Secret;
import com.itvdn.myUsersDB.petrov.user.User;
import com.itvdn.myUsersDB.petrov.user.UserData;
import com.itvdn.myUsersDB.petrov.user.form.Action;
import com.itvdn.myUsersDB.petrov.utils.*;
import com.itvdn.myUsersDB.petrov.user.form.UserForm;

import java.io.File;

public class Application {
    private final String EMPTY_DB = "{}";
    private static Application instance;

    private Application() {}

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    public void initDBFile() {
        File DBFile = new File(Config.getInstance().DB_PATH);
        if (!DBFile.exists()) {
            Parser.toJson(EMPTY_DB, Config.getInstance().DB_PATH);
        }
    }

    private User findUserInDB(String login) {
        return Parser.parseUser(login, Config.getInstance().DB_PATH);
    }

    private boolean addUserToDB(User user) throws UserExistException {
        String login = user.getAuthentication().getLogin();
        if (instance.findUserInDB(login) != null) {
            throw new UserExistException(login);
        }
        return updateUserInDB(user);
    }

    private boolean updateUserInDB(User user) {
        return Parser.addUserToJson(user, Config.getInstance().DB_PATH);
    }

    private UserForm[] getUserForms() {
        return Parser.parseJson(Config.getInstance().USER_FORMS, UserForm[].class);
    }

    private void processUserForm(UserForm userForm) {
        Action action = userForm.getAction();
        switch (action) {
            case REGISTRATION:
                if (Checker.registrationCheck(userForm)) {
                    UserData userData = new UserData(userForm.getFirstName(), userForm.getLastName(), userForm.getBirthday(), userForm.getEmail());
                    Authentication authentication = new Authentication(userForm.getLogin(), Encryptor.encrypt(userForm.getPassword()));
                    Secret secret = new Secret(userForm.getSecretQuestion(), userForm.getSecretAnswer());
                    User user = new User(userData, authentication, secret);
                    try {
                        addUserToDB(user);
                        Logger.info(action, user);
                    } catch (UserExistException e) {
                        Logger.error(action, e);
                    }
                } else {
                    Logger.info(action, " conditions not met for user '" + userForm.getLogin() + "'");
                }
                break;
            default:
                User user = findUserInDB(userForm.getLogin());
                if (user == null) {
                    try {
                        throw new UserNotExistException(userForm.getLogin());
                    } catch (UserNotExistException e) {
                        Logger.error(action, e);
                        break;
                    }
                }
                switch (userForm.getAction()) {
                    case CHANGE_PASSWORD:
                        if (Checker.changePasswordCheck(userForm, user) && Checker.checkNewPassword(userForm)) {
                            user.getAuthentication().setPassword(Encryptor.encrypt(userForm.getPassword()));
                            updateUserInDB(user);
                            Logger.info(action, user);
                        } else {
                            Logger.info(action, "There is not enough data to change the password or the new password does not meet the requirements");
                        }
                        break;
                    case CHANGE_USER_DATA:
                        if (Checker.authenticationCheck(userForm, user)) {
                            if (Checker.checkFirstName(userForm)) {
                                user.getUserData().setFirstName(userForm.getFirstName());
                            }
                            if (Checker.checkLastName(userForm)) {
                                user.getUserData().setLastName(userForm.getLastName());
                            }
                            if (Checker.checkBirthday(userForm)) {
                                user.getUserData().setBirthday(userForm.getBirthday());
                            }
                            if (Checker.checkEmail(userForm)) {
                                user.getUserData().setEmail(userForm.getEmail());
                            }
                            updateUserInDB(user);
                            Logger.info(action, user);
                        } else {
                            Logger.authenticationIsIncorrect(action, user);
                        }
                        break;
                    case CHANGE_SECRET_DATA:
                        if (Checker.authenticationCheck(userForm, user)) {
                            if (Checker.checkSecretQuestion(userForm)) {
                                user.getSecret().setQuestion(userForm.getSecretQuestion());
                            }
                            if (Checker.checkSecretAnswer(userForm)) {
                                user.getSecret().setAnswer(userForm.getSecretAnswer());
                            }
                            updateUserInDB(user);
                            Logger.info(action, user);
                        } else {
                            Logger.authenticationIsIncorrect(action, user);
                        }
                        break;
                    case SEND_USER_DATA:
                        if (Checker.authenticationCheck(userForm, user)) {
                            try {
                                Mailer.sendUserData(user);
                                Logger.info(action, user);
                            } catch (EmailEmptyException e) {
                                Logger.error(action, e);
                            }
                        } else {
                            Logger.authenticationIsIncorrect(action, user);
                        }
                        break;
                    case SEND_SECRET_DATA:
                        if (Checker.authenticationCheck(userForm, user)) {
                            try {
                                Mailer.sendSecretData(user);
                                Logger.info(action, user);
                            } catch (EmailEmptyException e) {
                                Logger.error(action, e);
                            }
                        } else {
                            Logger.authenticationIsIncorrect(action, user);
                        }
                        break;
                    default:
                        try {
                            throw new UnsupportedAction(userForm.getAction());
                        } catch (UnsupportedAction e) {
                            Logger.error(action, e);
                        }
                        break;
                }
                break;
        }
    }

    public void processUserForms() {
        for (UserForm userForm : getUserForms()) {
            processUserForm(userForm);
        }
    }
}
