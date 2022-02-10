import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.itvdn.myUsersDB.petrov.application.Application;
import com.itvdn.myUsersDB.petrov.application.ApplicationHandler;
import com.itvdn.myUsersDB.petrov.application.Config;
import com.itvdn.myUsersDB.petrov.exception.UserExistException;
import com.itvdn.myUsersDB.petrov.user.User;
import com.itvdn.myUsersDB.petrov.user.form.UserForm;
import com.itvdn.myUsersDB.petrov.utils.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
//        User user = Parser.parseUser("../MyUsersDB/src/main/resources/user.json");
//        System.out.println(user);
//        UserForm userForm = Parser.parseUserForm("../MyUsersDB/src/main/resources/userForm.json");
//        System.out.println(userForm);
//        List<String> list = new ArrayList<>();
//        list.add("DCkjCdCPKQMThUGw");
//        list.add("PbkWXQ2hjudR2ZEh");
//        list.add("fmuhdtp5dpbGvZY5");
//        list.add("jz8HfR9bnueesxAR");
//        list.add("BhMGS7dJ6HLTR2te");
//        list.add("Nr3EuHeQf6k3G3Pp");
//        list.add("LCErwG62ny6Pb55K");
//        list.add("gfn48zgv2tn9aVWj");
//        System.out.println(Config.getInstance().DB_PATH);
//        new ApplicationHandler().start();
        Application application = Application.getInstance();
        application.initDBFile();
        UserForm userForm = Parser.parseUserForm("../MyUsersDB/src/main/resources/userForm.json");
        // User user = Application.getInstance().findUserInDB("test.ttt");
        System.out.println(Config.getInstance().REQUIRED_USER_EMAIL);
    }
}
