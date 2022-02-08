import com.itvdn.myUsersDB.petrov.config.Config_;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(Config_.getInstance().USER_PERCENT_CORRECT_TOTAL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
