package com.itvdn.myUsersDB.petrov.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.itvdn.myUsersDB.petrov.application.Config;
import com.itvdn.myUsersDB.petrov.utils.Encryptor;

import java.util.Objects;

@JsonRootName("authentication")
public class Authentication {
    @JsonProperty
    private String login;
    @JsonProperty
    private String password;

    private Authentication() {
    }

    public Authentication(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Encryptor.encrypt(password);
    }

    public boolean checkLogin(String login) {
        return Objects.equals(login, this.login);
    }

    public boolean checkPassword(String password) {
        return Objects.equals(Encryptor.decrypt(password), Encryptor.decrypt(this.password));
    }

    public String getLogin() {
        return login;
    }

    public int getPercentCorrectData(String login, String password) {
        Config config = Config.getInstance();
        return (checkLogin(login) ? config.PERCENT_CORRECT_USER_LOGIN : config.ZERO) +
                (checkPassword(password) ? config.PERCENT_CORRECT_USER_PASSWORD : config.ZERO);
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
