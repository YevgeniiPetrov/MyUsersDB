package com.itvdn.myUsersDB.petrov.exception;

import com.itvdn.myUsersDB.petrov.user.form.Action;

public class UnsupportedAction extends Exception {
    public UnsupportedAction(Action action) {
        super("Action '" + action + "' unsupported");
    }
}
