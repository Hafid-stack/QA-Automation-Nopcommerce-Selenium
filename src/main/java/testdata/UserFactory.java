package testdata;

import models.NewUserSingup;
import models.UserData;
import net.datafaker.Faker;

import java.util.Random;

public class UserFactory {

    private NewUserSingup newUserSingup;
    private UserData userData;
    private Random random;
    private Faker faker=new Faker();

    public NewUserSingup getNewUserSingup() {
        newUserSingup = new NewUserSingup();
        newUserSingup.setName(faker.name().firstName());
        newUserSingup.setEmail(faker.internet().emailAddress());

        return newUserSingup;
    }
    public UserData getUserData() {
        userData = new UserData();
        String[] countries={"Canada","India","United States","Australia","New Zealand","Singapore"};
        int randomIndex = random.nextInt(countries.length);

        userData.firstName = faker.name().firstName();
        userData.lastName = faker.name().lastName();
        userData.phoneNumber = faker.phoneNumber().phoneNumber();
        userData.accountName = faker.name().fullName();
        userData.address1 = faker.address().fullAddress();
        userData.address2 = faker.address().streetAddress();
        userData.city = faker.address().city();
        userData.state = faker.address().state();
        userData.zipCode = faker.address().zipCode();
        userData.password = faker.phoneNumber().cellPhone()+"Password";
        userData.company = faker.company().name();
        userData.country = countries[randomIndex];
        userData.month=faker.
        return userData;
    }





}
