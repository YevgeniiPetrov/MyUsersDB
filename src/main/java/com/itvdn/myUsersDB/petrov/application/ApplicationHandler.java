package com.itvdn.myUsersDB.petrov.application;

public class ApplicationHandler {
    public void start() {
        Application application = Application.getInstance();
        application.initDBFile();
    }
}
