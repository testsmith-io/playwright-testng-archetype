#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.factories;

import com.github.javafaker.Faker;
import ${package}.api.models.Address;
import ${package}.api.models.UserRegistration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UserDataFactory {

    private static final Faker faker = new Faker(Locale.ENGLISH);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static UserRegistration createRandomUser() {
        return new UserRegistration(
                faker.name().firstName(),
                faker.name().lastName(),
                createRandomAddress(),
                faker.phoneNumber().phoneNumber(),
                generateRandomDateOfBirth(),
                generateSecurePassword(),
                faker.internet().emailAddress()
        );
    }

    public static UserRegistration createUserWithCustomEmail(String email) {
        return new UserRegistration(
                faker.name().firstName(),
                faker.name().lastName(),
                createRandomAddress(),
                faker.phoneNumber().phoneNumber(),
                generateRandomDateOfBirth(),
                generateSecurePassword(),
                email
        );
    }

    public static Address createRandomAddress() {
        return new Address(
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().state(),
                faker.address().country(),
                faker.address().zipCode()
        );
    }

    private static String generateRandomDateOfBirth() {
        LocalDate dob = LocalDate.now()
                .minusYears(faker.number().numberBetween(18, 80))
                .minusDays(faker.number().numberBetween(0, 365));
        return dob.format(DATE_FORMATTER);
    }

    private static String generateSecurePassword() {
        return faker.internet().password(10, 20, true, true, true) + "@1A";
    }
}
