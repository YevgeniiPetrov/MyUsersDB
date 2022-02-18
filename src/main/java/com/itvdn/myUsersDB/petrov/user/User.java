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

    public User(UserData userData, Authentication authentication, Secret secret) {
        this.userData = userData;
        this.authentication = authentication;
        this.secret = secret;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public Secret getSecret() {
        return secret;
    }

    public void setSecret(Secret secret) {
        this.secret = secret;
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
