package com.itvdn.myUsersDB.petrov.user.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
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
    private String newPassword;
    private boolean isNewPasswordSet;
    @JsonProperty
    private String secretQuestion;
    private boolean isSecretQuestionSet;
    @JsonProperty
    private String secretAnswer;
    private boolean isSecretAnswerSet;

    private void setFirstName(String firstName) {
        this.firstName = firstName;
        this.isFirstNameSet = true;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
        this.isLastNameSet = true;
    }

    private void setBirthday(Date birthday) {
        this.birthday = birthday;
        this.isBirthdaySet = true;
    }

    private void setEmail(String email) {
        this.email = email;
        this.isEmailSet = true;
    }

    private void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        this.isNewPasswordSet = true;
    }

    private void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
        this.isSecretQuestionSet = true;
    }

    private void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
        this.isSecretAnswerSet = true;
    }
}
