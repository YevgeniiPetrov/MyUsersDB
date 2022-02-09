import com.itvdn.myUsersDB.petrov.form.UserForm;
import com.itvdn.myUsersDB.petrov.user.User;
import com.itvdn.myUsersDB.petrov.utils.Parser;

public class Main {
    public static void main(String[] args) {
        //System.out.println(new User("Ivan", "Ivanov", null, "ivan.ivanov@gmail.com", "ivanov.i", "test"));
        //System.out.println(Encryption.decrypt(null));
        User user = Parser.parseUser("../MyUsersDB/src/main/java/com/itvdn/myUsersDB/petrov/storage/user.json");
        System.out.println(user);
        UserForm userForm = Parser.parseUserForm("../MyUsersDB/src/main/java/com/itvdn/myUsersDB/petrov/storage/userForm.json");
        System.out.println(userForm);
    }
}
