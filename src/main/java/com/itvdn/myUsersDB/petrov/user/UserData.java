package com.itvdn.myUsersDB.petrov.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.itvdn.myUsersDB.petrov.application.Config;

import java.util.Date;
import java.util.Objects;

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

    private boolean checkBirthday(Date birthday) {
        if (Config.getInstance().REQUIRED_USER_BIRTHDAY && birthday == null) {
            return false;
        }
        return Objects.equals(birthday, this.birthday);
    }

    private boolean checkEmail(String email) {
        if (Config.getInstance().REQUIRED_USER_EMAIL && email == null) {
            return false;
        }
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
