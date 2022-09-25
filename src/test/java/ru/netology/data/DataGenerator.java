package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    @Value
    public static class CardInfo {
        public String cardNumber;
        public String month;
        public String year;
        public String owner;
        public String cvc;

// Тест-кейсы;
// Тестовые данные для проверки поля "Номер карты";

        public static CardInfo getValidCardPayment() {
            CardInfo validCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return validCard;
        }

        public static CardInfo getCardWithRejectedNumber() {
            CardInfo invalidCard = new CardInfo(
                    getCardRejectedNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getInvalidCardNumber() {
            CardInfo invalidCard = new CardInfo(
                    "4444 4444 4444 4448",
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getCardNumberWithWordInNumber() {
            CardInfo invalidCard = new CardInfo(
                    "4444 abcd 4444 4441",
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getCardNumberFieldEmpty() {
            CardInfo invalidCard = new CardInfo(
                    "",
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getCardNumberFieldConsistsOfLetters() {
            CardInfo invalidCard = new CardInfo(
                    "Abc",
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getCardNumberFieldWithSpecialCharacters() {
            CardInfo invalidCard = new CardInfo(
                    generateSpecialCharacters(),
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getCardNumberFieldConsistsOneCharacter() {
            CardInfo invalidCard = new CardInfo(
                    "4",
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

//  Тестовые данные для проверки поля "Месяц";

        public static CardInfo getInvalidMonthField() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    "30",
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getMonthFieldWithSpecialCharacters() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateSpecialCharacters(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getMonthFieldEmpty() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    "",
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getMonthFieldOneCharacter() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    "0",
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getMonthFieldConsistsOfLetters() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    "Abc",
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getLastMonth() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateLastMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

//  Тестовые данные для проверки поля "Год";

        public static CardInfo getLastYear() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateLastYear(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getYearFieldWithSpecialCharacters() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateSpecialCharacters(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getYearFieldEmpty() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    "",
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getYearFieldOneCharacter() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    "0",
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getYearFieldConsistsOfLetters() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    "Abc",
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getYearHasExpired() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateYearHasExpired(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getYearBeforeExpirationDate() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateYearBeforeExpirationDate(),
                    generateValidOwner(),
                    generateValidCVC()
            );
            return invalidCard;
        }

//  Тестовые данные для проверки поля "Владелец";

        public static CardInfo getOwnerFieldWithLettersAndNumbers() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    "I5V8A5N",
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getOwnerFieldWithSpecialCharacters() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    generateSpecialCharacters(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getOwnerFieldEmpty() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    "",
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getOwnerFieldConsistsOneCharacters() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    "A",
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getOwnerFieldWithDoubleSurname() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    getNameWithDoubleSurname(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getOwnerFieldInCyrillic() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    generateOwnerFieldInCyrillic(),
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getOwnerFieldConsistsOfLettersDifferentRegister() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    "iVAn ivANOVICH",
                    generateValidCVC()
            );
            return invalidCard;
        }

        public static CardInfo getOwnerFieldWithMaxLength() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    "Ivvvvvvvvvvvvvvvvvvvvvvaaaaaaaaaaaaaaaaaaaaaaaaaannnnnnnnnnnnnnnnnnnnnnn",
                    generateValidCVC()
            );
            return invalidCard;
        }

//  Тестовые данные для проверки поля "CVC";

        public static CardInfo getInvalidCVCField() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    "000"
            );
            return invalidCard;
        }

        public static CardInfo getCVCFieldWithSpecialCharacters() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    generateSpecialCharacters()
            );
            return invalidCard;
        }

        public static CardInfo getCVCFieldEmpty() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    ""
            );
            return invalidCard;
        }

        public static CardInfo getCVCFieldConsistsOneCharacters() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    "8"
            );
            return invalidCard;
        }

        public static CardInfo getCVCFieldConsistsOfLetters() {
            CardInfo invalidCard = new CardInfo(
                    getValidCardNumber(),
                    generateValidMonth(),
                    generateValidYear(),
                    generateValidOwner(),
                    "Abc"
            );
            return invalidCard;
        }
    }

// Тестовые данные;

    private static final Faker faker = new Faker(new Locale("en"));

    private static String getValidCardNumber() {
        return "4444444444444441";
    }

    private static String getCardRejectedNumber() {
        return "4444444444444442";
    }

    private static String generateValidOwner() {
        Faker faker = new Faker(new Locale("en-AU"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    private static String generateOwnerFieldInCyrillic() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    private static String getNameWithDoubleSurname() {
        Faker faker = new Faker(new Locale("en-AU"));
        return faker.name().firstName() + " " + faker.name().lastName() + "-" + faker.name().lastName();
    }

    private static String generateSpecialCharacters() {
        Random rand = new Random();
        List<String> list = Arrays.asList("~", "`", "@", "!", "#", "$", "%", "^", "&", "*", "(", ")", "/", "+",
                "№", ";", ":", "?", "<", ">", "{", "}");
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }

    private static String generateValidCVC() {
        return faker.numerify("###");
    }

    private static String generateValidMonth() {
        LocalDate monthNow = LocalDate.now();
        return monthNow.format(DateTimeFormatter.ofPattern("MM"));
    }

    private static String generateLastMonth() {
        LocalDate monthLast = LocalDate.now().minusMonths(1);
        return monthLast.format(DateTimeFormatter.ofPattern("MM"));
    }

    private static String generateValidYear() {
        LocalDate yearNow = LocalDate.now();
        return yearNow.format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String generateLastYear() {
        LocalDate yearLast = LocalDate.now().minusYears(1);
        return yearLast.format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String generateYearHasExpired() {
        LocalDate yearExpired = LocalDate.now().plusYears(6);
        return yearExpired.format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String generateYearBeforeExpirationDate() {
        LocalDate yearBeforeExpired = LocalDate.now().plusYears(5);
        return yearBeforeExpired.format(DateTimeFormatter.ofPattern("yy"));
    }
}
