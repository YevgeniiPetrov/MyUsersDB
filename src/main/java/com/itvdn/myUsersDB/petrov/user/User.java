package com.itvdn.myUsersDB.petrov.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.itvdn.myUsersDB.petrov.config.Config;

import java.util.Date;

@JsonRootName("user")
public class User {
    @JsonProperty
    private UserData userData;
    @JsonProperty
    private Authentication authentication;
    @JsonProperty
    private Secret secret;

    private User() {}

    private User(UserData userData, Authentication authentication) {
        this.userData = userData;
        this.authentication = authentication;
    }

    public void setSecret(Secret secret) {
        this.secret = secret;
    }

    public boolean registrationCheck(String login, String password, Date birthday, String email, String question, String answer) {
        return login != null && password != null && recoveryCheck(login, password, birthday, email, question, answer);
    }

    public boolean recoveryCheck(String login, String password, Date birthday, String email, String question, String answer) {
        return (userData.getPercentCorrectData(birthday, email) +
                authentication.getPercentCorrectData(login, password) +
                secret.getPercentCorrectData(question, answer)) >= Config.getInstance().PERCENT_CORRECT_USER_DATA_TOTAL;
    }

    @Override
    public String toString() {
        return "User{" +
                "userData=" + userData +
                ", authentication=" + authentication +
                ", secret=" + secret +
                '}';
    }
}
