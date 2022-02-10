package com.itvdn.myUsersDB.petrov.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.itvdn.myUsersDB.petrov.application.Config;

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

    public Authentication getAuthentication() {
        return authentication;
    }

    public boolean recoveryCheck(
            String firstName, String lastName, Date birthday, String email,
            String login, String password, String secretQuestion, String secretAnswer) {
        return (userData.getPercentCorrectData(firstName, lastName, birthday, email) +
                authentication.getPercentCorrectData(login, password) +
                secret.getPercentCorrectData(secretQuestion, secretAnswer)) >= Config.getInstance().PERCENT_CORRECT_USER_DATA_TOTAL;
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
