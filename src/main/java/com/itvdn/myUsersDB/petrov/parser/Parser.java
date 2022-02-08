package com.itvdn.myUsersDB.petrov.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itvdn.myUsersDB.petrov.config.Config;
import com.itvdn.myUsersDB.petrov.config.Config_;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parser {
    private static Map<String, Object> getChildMap(Map<String, Object> parentMap, String key) {
        return (Map<String, Object>) parentMap.get(key);
    }

    private static int getChildInt(Map<String, Object> parentMap, String key) {
        return (int) parentMap.get(key);
    }

    public static Config parseConfig(String configPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> configMap = objectMapper.readValue(new File(configPath), Map.class);
        Map<String, Object> user = getChildMap(configMap, Config.ATTR_USER);
        Map<String, Object> percentCorrectData = getChildMap(user, Config.ATTR_PERCENT_CORRECT_DATA);
        Map<String, Object> userData = getChildMap(percentCorrectData, Config.ATTR_USER_DATA);
        Map<String, Object> secret = getChildMap(percentCorrectData, Config.ATTR_SECRET);
        int percentLogin = getChildInt(percentCorrectData, Config.ATTR_LOGIN);
        int percentPassword = getChildInt(percentCorrectData, Config.ATTR_PASSWORD);
        int percentBirthday = getChildInt(userData, Config.ATTR_BIRTHDAY);
        int percentEmail = getChildInt(userData, Config.ATTR_EMAIL);
        int percentQuestion = getChildInt(secret, Config.ATTR_QUESTION);
        int percentAnswer = getChildInt(secret, Config.ATTR_ANSWER);
        int percentCorrectTotal = getChildInt(percentCorrectData, Config.ATTR_PERCENT_CORRECT_TOTAL);
        Config.createInstance(
                percentLogin,
                percentPassword,
                percentBirthday,
                percentEmail,
                percentQuestion,
                percentAnswer,
                percentCorrectTotal);
        return Config.getInstance();
    }

    public static Config_ parseConfig_(String configPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(configPath), Config_.class);
    }
}
