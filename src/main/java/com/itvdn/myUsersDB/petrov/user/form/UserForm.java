package com.itvdn.myUsersDB.petrov.user.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class UserForm {
    @JsonProperty
    private Action action;
    @JsonProperty
    private String firstName;
    private boolean isFirstNameSet;
    @JsonProperty
    private String lastName;
    private boolean isLastNameSet;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date birthday;
    private boolean isBirthdaySet;
    @JsonProperty
    private String email;
    private boolean isEmailSet;
    @JsonProperty
    private String login;
    @JsonProperty
    private String password;
    @JsonProperty
    private String secretQuestion;
    private boolean isSecretQuestionSet;
    @JsonProperty
    private String secretAnswer;
    private boolean isSecretAnswerSet;

    public Action getAction() {
        return action;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
        this.isFirstNameSet = true;
    }

    public boolean isFirstNameSet() {
        return isFirstNameSet;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
        this.isLastNameSet = true;
    }

    public boolean isLastNameSet() {
        return isLastNameSet;
    }

    public Date getBirthday() {
        return birthday;
    }

    private void setBirthday(Date birthday) {
        this.birthday = birthday;
        this.isBirthdaySet = true;
    }

    public boolean isBirthdaySet() {
        return isBirthdaySet;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
        this.isEmailSet = true;
    }

    public boolean isEmailSet() {
        return isEmailSet;
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

    private void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
        this.isSecretQuestionSet = true;
    }

    public boolean isSecretQuestionSet() {
        return isSecretQuestionSet;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    private void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
        this.isSecretAnswerSet = true;
    }

    public boolean isSecretAnswerSet() {
        return isSecretAnswerSet;
    }

    @Override
    public String toString() {
        return "UserForm{" +
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
