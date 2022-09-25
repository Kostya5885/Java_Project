package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TitlePage {
    private final SelenideElement debitCardButton = $("[class='button button_size_m button_theme_alfa-on-white'] [class='button__text']");
    private final SelenideElement creditCardButton = $(byText("Купить в кредит"));

    public DebitCardPaymentPage debitCardPayment() {
        debitCardButton.click();
        return new DebitCardPaymentPage();
    }

    public CreditCardPaymentPage creditCardPayment() {
        creditCardButton.click();
        return new CreditCardPaymentPage();
    }
}