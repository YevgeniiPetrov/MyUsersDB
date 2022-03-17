package com.itvdn.myUsersDB.petrov.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName("authentication")
public class Authentication {
    @JsonProperty
    private String login;
    @JsonProperty
    private String password;

    private Authentication() {}

    public Authentication(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
