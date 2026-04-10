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
        userData.setGender(faker.number().numberBetween(1,3));
        userData.setFirstName(faker.name().firstName());
        userData.setLastName(faker.name().lastName());
        userData.setPhoneNumber(faker.phoneNumber().phoneNumber());
        userData.setAccountName(faker.name().fullName());
        userData.setAddress1(faker.address().fullAddress());
        userData.setAddress2(faker.address().streetAddress());
        userData.setState(faker.address().state().replaceAll(" ","-"));
        userData.setZipCode(faker.address().zipCode());
        userData.setPassword(faker.phoneNumber().cellPhone()+"Password");
        userData.setCompany(faker.company().name());
        userData.setCountry(faker.options().option("Canada","India","United States","Australia","New Zealand","Singapore"));
        userData.setMonth(faker.number().numberBetween(1,12));
        userData.setDay(faker.number().numberBetween(1,28));
        userData.setYear(faker.number().numberBetween(1888,2024));
        userData.setCity(faker.dungeonsAndDragons().cities().replaceAll(" ","-"));
        return userData;
    }





}
