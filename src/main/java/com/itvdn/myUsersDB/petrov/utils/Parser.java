package com.itvdn.myUsersDB.petrov.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.itvdn.myUsersDB.petrov.user.form.UserForm;
import com.itvdn.myUsersDB.petrov.user.User;

import java.io.File;
import java.io.IOException;

public class Parser {
    public static User parseUser(String filePath) {
        User user = null;
        try {
            user = new ObjectMapper().readValue(new File(filePath), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User parseUser(String login, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            ObjectNode node = objectMapper.readValue(new File(filePath), ObjectNode.class);
            if (node.has(login)) {
                user = objectMapper.treeToValue(node.get(login), User.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static UserForm parseUserForm(String filePath) {
        UserForm userForm = null;
        try {
            userForm = new ObjectMapper().readValue(new File(filePath), UserForm.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userForm;
    }

    public static void toJson(String string, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), objectMapper.readTree(string));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean addToJson(User user, String filePath) {
        boolean isAdded = true;
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        try {
            ObjectNode node = objectMapper.readValue(file, ObjectNode.class);
            node.putPOJO(user.getAuthentication().getLogin(), user);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, node);
        } catch (IOException e) {
            isAdded = false;
            e.printStackTrace();
        }
        return isAdded;
    }

    public static <T> T[] parseJson(String filePath, Class<T[]> clazz) {
        T[] objects = null;
        try {
            objects = new ObjectMapper().readValue(new File(filePath), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
