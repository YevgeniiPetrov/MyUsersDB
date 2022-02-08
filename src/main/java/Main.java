import com.itvdn.myUsersDB.petrov.config.Config;
import com.itvdn.myUsersDB.petrov.encryption.Encryption;
import com.itvdn.myUsersDB.petrov.parser.Parser;
import com.itvdn.myUsersDB.petrov.user.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //System.out.println(new User("Ivan", "Ivanov", null, "ivan.ivanov@gmail.com", "ivanov.i", "test"));
        //System.out.println(Encryption.decrypt(null));
        System.out.println(Parser.parseUser("../MyUsersDB/src/main/java/com/itvdn/myUsersDB/petrov/storage/user.json"));
    }
}
