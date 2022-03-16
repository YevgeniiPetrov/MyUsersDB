package com.itvdn.myUsersDB.petrov.application;

import com.itvdn.myUsersDB.petrov.utils.Logger;

public class ApplicationHandler {
    public void start() {
        Application application = Application.getInstance();
        Logger.info("================== Application is started ==================");
        application.initDBFile();
        Logger.info("Config is initialized");
        Logger.info("Start to process user forms");
        application.processUserForms();
        Logger.info(" ================== Application is stopped ==================");
    }
}
