package com.itvdn.myUsersDB.petrov.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonRootName("secret")
public class Secret {
    @JsonProperty
    private String question;
    @JsonProperty
    private String answer;

    private Secret() {}

    public Secret(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
