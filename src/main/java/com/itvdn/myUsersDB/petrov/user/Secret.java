package com.itvdn.myUsersDB.petrov.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.itvdn.myUsersDB.petrov.application.Config;

import java.util.Objects;

@JsonRootName("secret")
public class Secret {
    @JsonProperty
    private String question;
    @JsonProperty
    private String answer;

    private Secret() {
    }

    public Secret(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean checkQuestion(String question) {
        return Objects.equals(question, this.question);
    }

    public boolean checkAnswer(String answer) {
        return Objects.equals(answer, this.answer);
    }

    public int getPercentCorrectData(String question, String answer) {
        Config config = Config.getInstance();
        return (checkQuestion(question) ? config.PERCENT_CORRECT_USER_SECRET_QUESTION : config.ZERO) +
                (checkAnswer(answer) ? config.PERCENT_CORRECT_USER_SECRET_ANSWER : config.ZERO);
    }

    @Override
    public String toString() {
        return "Secret{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
