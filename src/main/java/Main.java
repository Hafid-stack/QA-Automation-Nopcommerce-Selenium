import models.NewUserSingup;
import models.UserData;
import testdata.UserFactory;

public class Main {
    public static void main(String[] args) {


        UserFactory userFactory = new UserFactory();
        NewUserSingup newUserSingup = userFactory.getNewUserSingup();
        System.out.println(newUserSingup.getName());
        System.out.println(newUserSingup.getEmail());
    }
}
