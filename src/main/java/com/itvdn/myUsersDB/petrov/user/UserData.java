package com.itvdn.myUsersDB.petrov.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.itvdn.myUsersDB.petrov.config.Config;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@JsonRootName(value = "userData")
public class UserData {
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonFormat(pattern="dd.MM.yyyy")
    private Date birthday;
    @JsonProperty
    private String email;

    private UserData() {

    }

    public UserData(String firstName, String lastName, Date birthday, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
    }

    private boolean checkBirthday(Date birthday) {
        return Objects.equals(birthday, this.birthday);
    }

    private boolean checkEmail(String email) {
        return Objects.equals(email, this.email);
    }

    public int getPercentCorrectData(Date birthday, String email) {
        Config config = Config.getInstance();
        return (checkBirthday(birthday) ? config.PERCENT_CORRECT_USER_BIRTHDAY : config.ZERO) +
                (checkEmail(email) ? config.PERCENT_CORRECT_USER_EMAIL : config.ZERO);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
