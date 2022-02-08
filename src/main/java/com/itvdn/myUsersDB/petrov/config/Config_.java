package com.itvdn.myUsersDB.petrov.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itvdn.myUsersDB.petrov.parser.Parser;

import java.io.IOException;

public class Config_ {
    private static Config_ instance;
    private static final String CONFIG_PATH = "../MyUsersDB/src/main/java/com/itvdn/myUsersDB/petrov/config/config.json";
    public final int USER_PERCENT_LOGIN;
    public final int USER_PERCENT_PASSWORD;
    public final int USER_PERCENT_BIRTHDAY;
    public final int USER_PERCENT_EMAIL;
    public final int USER_PERCENT_SECRET_QUESTION;
    public final int USER_PERCENT_SECRET_ANSWER;
    public final int USER_PERCENT_CORRECT_TOTAL;
    public final int ZERO = 0;

    @JsonCreator
    private Config_(
            @JsonProperty("percentCorrectUserLogin") int percentCorrectUserLogin,
            @JsonProperty("percentCorrectUserPassword") int percentCorrectUserPassword,
            @JsonProperty("percentCorrectUserBirthday") int percentCorrectUserBirthday,
            @JsonProperty("percentCorrectUserEmail") int percentCorrectUserEmail,
            @JsonProperty("percentCorrectUserSecretQuestion") int percentCorrectUserSecretQuestion,
            @JsonProperty("percentCorrectUserSecretAnswer") int percentCorrectUserSecretAnswer,
            @JsonProperty("percentCorrectUserDataTotal") int percentCorrectUserDataTotal) {
        USER_PERCENT_LOGIN = percentCorrectUserLogin;
        USER_PERCENT_PASSWORD = percentCorrectUserPassword;
        USER_PERCENT_BIRTHDAY = percentCorrectUserBirthday;
        USER_PERCENT_EMAIL = percentCorrectUserEmail;
        USER_PERCENT_SECRET_QUESTION = percentCorrectUserSecretQuestion;
        USER_PERCENT_SECRET_ANSWER = percentCorrectUserSecretAnswer;
        USER_PERCENT_CORRECT_TOTAL = percentCorrectUserDataTotal;
    }

    public static Config_ getInstance() throws IOException {
        if (instance == null) {
            instance = Parser.parseConfig_(CONFIG_PATH);
        }
        return instance;
    }
}
