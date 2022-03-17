package com.itvdn.myUsersDB.petrov.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;

@Getter
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
}
