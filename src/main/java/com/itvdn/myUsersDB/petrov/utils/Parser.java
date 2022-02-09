package com.itvdn.myUsersDB.petrov.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itvdn.myUsersDB.petrov.form.UserForm;
import com.itvdn.myUsersDB.petrov.user.User;

import java.io.File;
import java.io.IOException;

public class Parser {
    public static User parseUser(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            user = objectMapper.readValue(new File(filePath), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static UserForm parseUserForm(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserForm userForm = null;
        try {
            userForm = objectMapper.readValue(new File(filePath), UserForm.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userForm;
    }
}
