package testdata;

import models.NewUserSingup;
import models.UserData;
import net.datafaker.Faker;


public class UserFactory {

//    private  newUserSingup;
//    private  userData;
//    private Random random;
    private Faker faker=new Faker();

    public NewUserSingup getNewUserSingup() {
        NewUserSingup newUserSingup = new NewUserSingup();
        newUserSingup.setName(faker.name().firstName());
        newUserSingup.setEmail(faker.internet().emailAddress());

        return newUserSingup;
    }
    public UserData getUserData() {
        UserData userData = new UserData();
        //String[] countries={"Canada","India","United States","Australia","New Zealand","Singapore"};
        //int randomIndex = random.nextInt(countries.length);
        //depricated
        //Timestamp timestamp = faker.date().birthday(18,65);
        //LocalDate dob = timestamp.toLocalDateTime().toLocalDate();
        userData.gender=faker.number().numberBetween(1,2);
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
        userData.country = faker.options().option("Canada","India","United States","Australia","New Zealand","Singapore");
        userData.month=faker.number().numberBetween(1,12);
        userData.day=faker.number().numberBetween(1,28);
        userData.year=faker.number().numberBetween(1888,2024);

        return userData;
    }





}
