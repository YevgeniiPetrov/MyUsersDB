package com.itvdn.myUsersDB.petrov.application;

import com.itvdn.myUsersDB.petrov.exception.UserExistException;
import com.itvdn.myUsersDB.petrov.user.User;
import com.itvdn.myUsersDB.petrov.user.form.UserForm;
import com.itvdn.myUsersDB.petrov.utils.Parser;

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

    public User findUserInDB(String login) {
        return Parser.parseUser(login, Config.getInstance().DB_PATH);
    }

    public boolean addUserToDB(User user) throws UserExistException {
        String login = user.getAuthentication().getLogin();
        if (instance.findUserInDB(login) != null) {
            throw new UserExistException("user with login '" + login + "' already exists");
        }
        return updateUserInDB(user);
    }

    public boolean updateUserInDB(User user) {
        return Parser.addToJson(user, Config.getInstance().DB_PATH);
    }

    private UserForm[] getUserForms() {
        return Parser.parseJson(Config.getInstance().USER_FORMS, UserForm[].class);
    }

    private void processUserForm(UserForm userForm) {
        switch (userForm.getAction()) {
            case REGISTRATION:
                //if (userForm.getUser().)
                break;
        }
    }

    public void processUserForms() {

    }
}
