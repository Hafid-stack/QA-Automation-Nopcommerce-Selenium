package testdata;

import models.FakeCardData;
import net.datafaker.Faker;

public class Generator {

    private Faker faker=new Faker();

    public String generateComment() {


        return faker.text().text(50,300);
    }
    public FakeCardData generateFakeCardData() {
        FakeCardData fakeCardData=new FakeCardData(
                faker.name().fullName(),
                String.valueOf(faker.number().digits(3)),
                String.format("%02d", faker.number().numberBetween(1, 13)),
                String.valueOf(faker.number().numberBetween(27, 35)),
                faker.finance().creditCard().replaceAll("-","")
        );
        return fakeCardData;
    }
}
