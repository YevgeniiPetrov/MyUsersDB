package com.itvdn.myUsersDB.petrov.application;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itvdn.myUsersDB.petrov.utils.Logger;

import java.io.File;
import java.io.IOException;

public class Config {
    private static Config instance;
    private static final String CONFIG_PATH = "../MyUsersDB/src/main/resources/config.json";
    public final int MIN_LENGTH_USER_LOGIN;
    public final int MAX_LENGTH_USER_LOGIN;
    public final int MIN_LENGTH_USER_PASSWORD;
    public final int MAX_LENGTH_USER_PASSWORD;
    public final boolean REQUIRED_USER_FIRST_NAME;
    public final boolean REQUIRED_USER_LAST_NAME;
    public final boolean REQUIRED_USER_BIRTHDAY;
    public final boolean REQUIRED_USER_EMAIL;
    public final boolean REQUIRED_USER_SECRET;
    public final int PERCENT_CORRECT_USER_FIRST_NAME;
    public final int PERCENT_CORRECT_USER_LAST_NAME;
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
    public final String LOGS_PATH;

    @JsonCreator
    private Config(
            @JsonProperty("minLengthUserLogin") int minLengthUserLogin,
            @JsonProperty("maxLengthUserLogin") int maxLengthUserLogin,
            @JsonProperty("minLengthUserPassword") int minLengthUserPassword,
            @JsonProperty("maxLengthUserPassword") int maxLengthUserPassword,
            @JsonProperty("requiredUserFirstName") boolean requiredUserFirstName,
            @JsonProperty("requiredUserLastName") boolean requiredUserLastName,
            @JsonProperty("requiredUserBirthday") boolean requiredUserBirthday,
            @JsonProperty("requiredUserEmail") boolean requiredUserEmail,
            @JsonProperty("requiredUserSecret") boolean requiredUserSecret,
            @JsonProperty("percentCorrectUserFirstName") int percentCorrectUserFirstName,
            @JsonProperty("percentCorrectUserLastName") int percentCorrectUserLastName,
            @JsonProperty("percentCorrectUserLogin") int percentCorrectUserLogin,
            @JsonProperty("percentCorrectUserPassword") int percentCorrectUserPassword,
            @JsonProperty("percentCorrectUserBirthday") int percentCorrectUserBirthday,
            @JsonProperty("percentCorrectUserEmail") int percentCorrectUserEmail,
            @JsonProperty("percentCorrectUserSecretQuestion") int percentCorrectUserSecretQuestion,
            @JsonProperty("percentCorrectUserSecretAnswer") int percentCorrectUserSecretAnswer,
            @JsonProperty("percentCorrectUserDataTotal") int percentCorrectUserDataTotal,
            @JsonProperty("DBPath") String DBPath,
            @JsonProperty("userForms") String userForms,
            @JsonProperty("logsPath") String logsPath) {
        MIN_LENGTH_USER_LOGIN = minLengthUserLogin;
        MAX_LENGTH_USER_LOGIN = maxLengthUserLogin;
        MIN_LENGTH_USER_PASSWORD = minLengthUserPassword;
        MAX_LENGTH_USER_PASSWORD = maxLengthUserPassword;
        REQUIRED_USER_FIRST_NAME = requiredUserFirstName;
        REQUIRED_USER_BIRTHDAY = requiredUserBirthday;
        REQUIRED_USER_EMAIL = requiredUserEmail;
        REQUIRED_USER_LAST_NAME = requiredUserLastName;
        REQUIRED_USER_SECRET = requiredUserSecret;
        PERCENT_CORRECT_USER_FIRST_NAME = percentCorrectUserFirstName;
        PERCENT_CORRECT_USER_LAST_NAME = percentCorrectUserLastName;
        PERCENT_CORRECT_USER_LOGIN = percentCorrectUserLogin;
        PERCENT_CORRECT_USER_PASSWORD = percentCorrectUserPassword;
        PERCENT_CORRECT_USER_BIRTHDAY = percentCorrectUserBirthday;
        PERCENT_CORRECT_USER_EMAIL = percentCorrectUserEmail;
        PERCENT_CORRECT_USER_SECRET_QUESTION = percentCorrectUserSecretQuestion;
        PERCENT_CORRECT_USER_SECRET_ANSWER = percentCorrectUserSecretAnswer;
        PERCENT_CORRECT_USER_DATA_TOTAL = percentCorrectUserDataTotal;
        DB_PATH = DBPath;
        USER_FORMS = userForms;
        LOGS_PATH = logsPath;
    }

    private static Config parseConfig() {
        ObjectMapper objectMapper = new ObjectMapper();
        Config config = null;
        try {
            config = objectMapper.readValue(new File(CONFIG_PATH), Config.class);
        } catch (IOException e) {
            Logger.error(e.getMessage());
            System.exit(1);
        }
        return config;
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = parseConfig();
        }
        return instance;
    }
}
