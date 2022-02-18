package com.itvdn.myUsersDB.petrov.user.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Action {
    @JsonProperty("registration")
    REGISTRATION,
    @JsonProperty("changePassword")
    CHANGE_PASSWORD,
    @JsonProperty("changeUserData")
    CHANGE_USER_DATA,
    @JsonProperty("changeSecretData")
    CHANGE_SECRET_DATA,
    @JsonProperty("sendUserData")
    SEND_USER_DATA,
    @JsonProperty("sendSecretData")
    SEND_SECRET_DATA,
}
