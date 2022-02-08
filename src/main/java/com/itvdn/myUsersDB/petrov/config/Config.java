package com.itvdn.myUsersDB.petrov.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Config {
    private static Config instance;
    private static final String CONFIG_PATH = "../MyUsersDB/src/main/java/com/itvdn/myUsersDB/petrov/config/config.json";
    public final int PERCENT_CORRECT_USER_LOGIN;
    public final int PERCENT_CORRECT_USER_PASSWORD;
    public final int PERCENT_CORRECT_USER_BIRTHDAY;
    public final int PERCENT_CORRECT_USER_EMAIL;
    public final int PERCENT_CORRECT_USER_SECRET_QUESTION;
    public final int PERCENT_CORRECT_USER_SECRET_ANSWER;
    public final int PERCENT_CORRECT_USER_DATA_TOTAL;
    public final int ZERO = 0;

    @JsonCreator
    private Config(
            @JsonProperty("percentCorrectUserLogin") int percentCorrectUserLogin,
            @JsonProperty("percentCorrectUserPassword") int percentCorrectUserPassword,
            @JsonProperty("percentCorrectUserBirthday") int percentCorrectUserBirthday,
            @JsonProperty("percentCorrectUserEmail") int percentCorrectUserEmail,
            @JsonProperty("percentCorrectUserSecretQuestion") int percentCorrectUserSecretQuestion,
            @JsonProperty("percentCorrectUserSecretAnswer") int percentCorrectUserSecretAnswer,
            @JsonProperty("percentCorrectUserDataTotal") int percentCorrectUserDataTotal) {
        PERCENT_CORRECT_USER_LOGIN = percentCorrectUserLogin;
        PERCENT_CORRECT_USER_PASSWORD = percentCorrectUserPassword;
        PERCENT_CORRECT_USER_BIRTHDAY = percentCorrectUserBirthday;
        PERCENT_CORRECT_USER_EMAIL = percentCorrectUserEmail;
        PERCENT_CORRECT_USER_SECRET_QUESTION = percentCorrectUserSecretQuestion;
        PERCENT_CORRECT_USER_SECRET_ANSWER = percentCorrectUserSecretAnswer;
        PERCENT_CORRECT_USER_DATA_TOTAL = percentCorrectUserDataTotal;
    }

    private static Config parseConfig() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(CONFIG_PATH), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = parseConfig();
        }
        return instance;
    }
}
