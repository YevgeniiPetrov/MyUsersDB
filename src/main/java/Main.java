import com.itvdn.myUsersDB.petrov.config.Config;
import com.itvdn.myUsersDB.petrov.parser.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Config config = Parser.parseConfig("../MyUsersDB/src/main/java/com/itvdn/myUsersDB/petrov/config/config.json");
            System.out.println(config.USER_PERCENT_LOGIN);
            System.out.println(config.USER_PERCENT_CORRECT_TOTAL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
