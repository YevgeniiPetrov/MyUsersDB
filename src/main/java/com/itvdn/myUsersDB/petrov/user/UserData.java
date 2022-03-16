package com.itvdn.myUsersDB.petrov.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonRootName("userData")
public class UserData {
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date birthday;
    @JsonProperty
    private String email;

    private UserData() {}

    public UserData(String firstName, String lastName, Date birthday, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
    }
}
