package com.itvdn.myUsersDB.petrov.user.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class UserForm {
    @JsonProperty
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    private Action action;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date birthday;
    @JsonProperty
    private String email;
    @JsonProperty
    private String login;
    @JsonProperty
    private String password;
    @JsonProperty
    private String secretQuestion;
    @JsonProperty
    private String secretAnswer;

    public Action getAction() {
        return action;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    @Override
    public String toString() {
        return "UserForm_{" +
                "action=" + action +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", secretQuestion='" + secretQuestion + '\'' +
                ", secretAnswer='" + secretAnswer + '\'' +
                '}';
    }
}
