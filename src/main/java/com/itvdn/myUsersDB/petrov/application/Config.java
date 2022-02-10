package com.itvdn.myUsersDB.petrov.application;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Config {
    private static Config instance;
    private static final String CONFIG_PATH = "../MyUsersDB/src/main/resources/config.json";
    public final int MIN_LENGTH_USER_LOGIN;
    public final int MAX_LENGTH_USER_LOGIN;
    public final int MIN_LENGTH_USER_PASSWORD;
    public final int MAX_LENGTH_USER_PASSWORD;
    public final boolean REQUIRED_USER_BIRTHDAY;
    public final boolean REQUIRED_USER_EMAIL;
    public final boolean REQUIRED_USER_SECRET;
    public final int PERCENT_CORRECT_USER_LOGIN;
    public final int PERCENT_CORRECT_USER_PASSWORD;
    public final int PERCENT_CORRECT_USER_BIRTHDAY;
    public final int PERCENT_CORRECT_USER_EMAIL;
    public final int PERCENT_CORRECT_USER_SECRET_QUESTION;
    public final int PERCENT_CORRECT_USER_SECRET_ANSWER;
    public final int PERCENT_CORRECT_USER_DATA_TOTAL;
    public final int ZERO = 0;
    public final String DB_PATH;
    public final String USER_FORMS;

    @JsonCreator
    private Config(
            @JsonProperty("minLengthUserLogin") int minLengthUserLogin,
            @JsonProperty("maxLengthUserLogin") int maxLengthUserLogin,
            @JsonProperty("minLengthUserPassword") int minLengthUserPassword,
            @JsonProperty("maxLengthUserPassword") int maxLengthUserPassword,
            @JsonProperty("requiredUserBirthday") boolean requiredUserBirthday,
            @JsonProperty("requiredUserEmail") boolean requiredUserEmail,
            @JsonProperty("requiredUserSecret") boolean requiredUserSecret,
            @JsonProperty("percentCorrectUserLogin") int percentCorrectUserLogin,
            @JsonProperty("percentCorrectUserPassword") int percentCorrectUserPassword,
            @JsonProperty("percentCorrectUserBirthday") int percentCorrectUserBirthday,
            @JsonProperty("percentCorrectUserEmail") int percentCorrectUserEmail,
            @JsonProperty("percentCorrectUserSecretQuestion") int percentCorrectUserSecretQuestion,
            @JsonProperty("percentCorrectUserSecretAnswer") int percentCorrectUserSecretAnswer,
            @JsonProperty("percentCorrectUserDataTotal") int percentCorrectUserDataTotal,
            @JsonProperty("DBPath") String DBPath,
            @JsonProperty("userForms") String userForms) {
        MIN_LENGTH_USER_LOGIN = minLengthUserLogin;
        MAX_LENGTH_USER_LOGIN = maxLengthUserLogin;
        MIN_LENGTH_USER_PASSWORD = minLengthUserPassword;
        MAX_LENGTH_USER_PASSWORD = maxLengthUserPassword;
        REQUIRED_USER_BIRTHDAY = requiredUserBirthday;
        REQUIRED_USER_EMAIL = requiredUserEmail;
        REQUIRED_USER_SECRET = requiredUserSecret;
        PERCENT_CORRECT_USER_LOGIN = percentCorrectUserLogin;
        PERCENT_CORRECT_USER_PASSWORD = percentCorrectUserPassword;
        PERCENT_CORRECT_USER_BIRTHDAY = percentCorrectUserBirthday;
        PERCENT_CORRECT_USER_EMAIL = percentCorrectUserEmail;
        PERCENT_CORRECT_USER_SECRET_QUESTION = percentCorrectUserSecretQuestion;
        PERCENT_CORRECT_USER_SECRET_ANSWER = percentCorrectUserSecretAnswer;
        PERCENT_CORRECT_USER_DATA_TOTAL = percentCorrectUserDataTotal;
        DB_PATH = DBPath;
        USER_FORMS = userForms;
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
