import com.fasterxml.jackson.core.JsonProcessingException;
import com.itvdn.myUsersDB.petrov.application.Application;
import com.itvdn.myUsersDB.petrov.application.Config;
import com.itvdn.myUsersDB.petrov.user.form.UserForm;
import com.itvdn.myUsersDB.petrov.utils.Parser;

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
//        Application application = Application.getInstance();
//        application.initDBFile();
//        UserForm userForm = Parser.parseUserForm("../MyUsersDB/src/main/resources/userForm.json");
//        // User user = Application.getInstance().findUserInDB("test.ttt");
//        System.out.println(userForm);
//        System.out.println(String.CASE_INSENSITIVE_ORDER.getClass());
        int number = 1;
        switch (number) {
            case 1 | 2 :
                System.out.println("+");
                break;
        }
    }
}
