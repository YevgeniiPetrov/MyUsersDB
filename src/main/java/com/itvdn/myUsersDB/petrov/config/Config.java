package com.itvdn.myUsersDB.petrov.config;

public class Config {
    public static final String ATTR_USER = "user";
    public static final String ATTR_PERCENT_CORRECT_DATA = "percentCorrectData";
    public static final String ATTR_LOGIN = "login";
    public static final String ATTR_PASSWORD = "password";
    public static final String ATTR_USER_DATA = "userData";
    public static final String ATTR_BIRTHDAY = "birthday";
    public static final String ATTR_EMAIL = "email";
    public static final String ATTR_SECRET = "secret";
    public static final String ATTR_QUESTION = "question";
    public static final String ATTR_ANSWER = "answer";
    public static final String ATTR_PERCENT_CORRECT_TOTAL = "percentCorrectTotal";

    private static Config instance;

    public final int ZERO = 0;
    public final int USER_PERCENT_LOGIN;
    public final int USER_PERCENT_PASSWORD;
    public final int USER_PERCENT_BIRTHDAY;
    public final int USER_PERCENT_EMAIL;
    public final int USER_PERCENT_SECRET_QUESTION;
    public final int USER_PERCENT_SECRET_ANSWER;
    public final int USER_PERCENT_CORRECT_TOTAL;

    private Config(
            int userPercentLogin,
            int userPercentPassword,
            int userPercentBirthday,
            int userPercentEmail,
            int userPercentSecretQuestion,
            int userPercentSecretAnswer,
            int userPercentCorrectTotal) {
        this.USER_PERCENT_LOGIN = userPercentLogin;
        this.USER_PERCENT_PASSWORD = userPercentPassword;
        this.USER_PERCENT_BIRTHDAY = userPercentBirthday;
        this.USER_PERCENT_EMAIL = userPercentEmail;
        this.USER_PERCENT_SECRET_QUESTION = userPercentSecretQuestion;
        this.USER_PERCENT_SECRET_ANSWER = userPercentSecretAnswer;
        this.USER_PERCENT_CORRECT_TOTAL = userPercentCorrectTotal;
    }

    public static void createInstance(
            int userPercentLogin,
            int userPercentPassword,
            int userPercentBirthday,
            int userPercentEmail,
            int userPercentSecretQuestion,
            int userPercentSecretAnswer,
            int userPercentCorrectTotal) {
        if (instance == null) {
            instance = new Config(
                    userPercentLogin,
                    userPercentPassword,
                    userPercentBirthday,
                    userPercentEmail,
                    userPercentSecretQuestion,
                    userPercentSecretAnswer,
                    userPercentCorrectTotal);
        }
    }

    public static Config getInstance() {
        return instance;
    }
}
