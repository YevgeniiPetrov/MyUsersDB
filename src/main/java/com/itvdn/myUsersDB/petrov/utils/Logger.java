package com.itvdn.myUsersDB.petrov.utils;

import com.itvdn.myUsersDB.petrov.application.Config;
import com.itvdn.myUsersDB.petrov.user.User;
import com.itvdn.myUsersDB.petrov.user.form.Action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Logger {
    private enum LoggerType {
        INFO,
        ERROR
    }

    private LocalDate loggerDate;
    private File log;
    private static Logger instance;

    private Logger() {}

    private static Logger getInstance() {
        if (instance == null || LocalDate.now().equals(instance.loggerDate)) {
            instance = new Logger();
            instance.loggerDate = LocalDate.now();
            instance.log = getLogFile();
        }
        return instance;
    }

    private static File getLogFile() {
        File log = new File(getLogDirectory() + "/log_" + LocalDate.now() + ".txt");
        if (!log.exists()) {
            try {
                log.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return log;
    }

    private static File getLogDirectory() {
        File directory = new File(Config.getInstance().LOGS_PATH);
        if (!directory.exists()){
            directory.mkdir();
        }
        return directory;
    }

    private static void log(LoggerType loggerType, String message) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(getInstance().log, true))) {
            String line = "(" + LocalDate.now() + " " + LocalTime.now() + ") " + loggerType + " - " + message + "\n";
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void info(String message) {
        log(LoggerType.INFO, message);
    }

    public static void info(Action action, User user) {
        String message = action + " for login " + user.getAuthentication().getLogin() + "' successful";
        info(message);
    }

    public static void info(Action action, String message) {
        info(action + " " + message);
    }

    public static void authenticationIsIncorrect(Action action, User user) {
        String message = action + " for login " + user.getAuthentication().getLogin() + "' unsuccessful: login or password is incorrect";
        info(message);
    }

    public static void error(String message) {
        log(LoggerType.ERROR, message);
    }

    public static void error(Action action, Exception exception) {
        String message = action + ". " + exception.getMessage();
        error(message);
    }
}
