package com.itvdn.myUsersDB.petrov.user;

import com.itvdn.myUsersDB.petrov.config.Config;

import java.time.LocalDate;
import java.util.Objects;

public class UserData {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;

    UserData(String firstName, String lastName, LocalDate birthday, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
    }

    private boolean checkBirthday(LocalDate birthday) {
        return Objects.equals(birthday, this.birthday);
    }

    private boolean checkEmail(String email) {
        return Objects.equals(email, this.email);
    }

    public int getPercentCorrectData(LocalDate birthday, String email) {
        Config config = Config.getInstance();
        return (checkBirthday(birthday) ? config.USER_PERCENT_BIRTHDAY : config.ZERO) +
                (checkEmail(email) ? config.USER_PERCENT_EMAIL : config.ZERO);
    }
}
