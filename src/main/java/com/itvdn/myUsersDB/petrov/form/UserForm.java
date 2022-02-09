package com.itvdn.myUsersDB.petrov.form;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itvdn.myUsersDB.petrov.user.User;

public class UserForm {
    @JsonProperty
    private Action action;
    @JsonProperty
    private User user;

    @Override
    public String toString() {
        return "UserForm{" +
                "action=" + action +
                ", user=" + user +
                '}';
    }
}
