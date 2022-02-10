package com.itvdn.myUsersDB.petrov.user.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itvdn.myUsersDB.petrov.user.User;

public class UserForm {
    @JsonProperty
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    private Action action;
    @JsonProperty
    private User user;

    public Action getAction() {
        return action;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "action=" + action +
                ", user=" + user +
                '}';
    }
}
