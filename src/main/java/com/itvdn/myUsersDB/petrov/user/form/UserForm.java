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
    private boolean isLoginSet;
    @JsonProperty
    private String password;
    private boolean isPasswordSet;
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

    private void setLogin(String login) {
        this.login = login;
        this.isLoginSet = true;
    }

    public boolean isLoginSet() {
        return isLoginSet;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
        this.isPasswordSet = true;
    }

    public boolean isPasswordSet() {
        return isPasswordSet;
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
                ", isFirstNameSet=" + isFirstNameSet +
                ", lastName='" + lastName + '\'' +
                ", isLastNameSet=" + isLastNameSet +
                ", birthday=" + birthday +
                ", isBirthdaySet=" + isBirthdaySet +
                ", email='" + email + '\'' +
                ", isEmailSet=" + isEmailSet +
                ", login='" + login + '\'' +
                ", isLoginSet=" + isLoginSet +
                ", password='" + password + '\'' +
                ", isPasswordSet=" + isPasswordSet +
                ", secretQuestion='" + secretQuestion + '\'' +
                ", isSecretQuestionSet=" + isSecretQuestionSet +
                ", secretAnswer='" + secretAnswer + '\'' +
                ", isSecretAnswerSet=" + isSecretAnswerSet +
                '}';
    }
}
