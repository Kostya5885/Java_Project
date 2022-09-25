package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
public class DebitCardPaymentPage {

    private SelenideElement debitCardText = $(byText("Оплата по карте"));
    private SelenideElement debitCardButton = $("[class='button button_size_m button_theme_alfa-on-white'] [class='button__text']");
    private SelenideElement cardNumberField = $("[class='form-field form-field_size_m form-field_theme_alfa-on-white'] [class='input__control']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement ownerField = $$(".input").find(exactText("Владелец")).$(".input__control");
    private SelenideElement cvvField = $("[placeholder='999']");
    private SelenideElement nextButton = $$(".button").find(exactText("Продолжить"));

    public void isVisibleDebitCard() {
        debitCardText.shouldBe(Condition.visible);
    }

    //    Успешная отправка формы;
    public void validFillFieldDebitCard(DataGenerator.CardInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvvField.setValue(info.getCvc());
        nextButton.click();
        new DebitCardPaymentPage();
    }

    //    Ошибка при отправке формы;
    public void invalidFillFieldDebitCard(DataGenerator.CardInfo info) {
        cardNumberField.sendKeys(Keys.DELETE);
        cardNumberField.setValue(info.getCardNumber());
        monthField.sendKeys(Keys.DELETE);
        monthField.setValue(info.getMonth());
        yearField.sendKeys(Keys.DELETE);
        yearField.setValue(info.getYear());
        ownerField.sendKeys(Keys.DELETE);
        ownerField.setValue(info.getOwner());
        cvvField.sendKeys(Keys.DELETE);
        cvvField.setValue(info.getCvc());
        nextButton.click();
        new DebitCardPaymentPage();
    }
    public void approvedMessage() {
        $("[class='notification notification_visible notification_status_ok notification_has-closer notification_stick-to_right notification_theme_alfa-on-white']").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void errorBankRefusalMessage() {
        $("[class='notification notification_visible notification_status_error notification_has-closer notification_stick-to_right notification_theme_alfa-on-white']").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void errorMessageIncorrectFormat() {
        $(byText("Неверный формат")).shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void errorMessageEmptyField() {
        $(byText("Поле обязательно для заполнения")).shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void errorMessageCardExpirationDateIncorrect() {
        $(byText("Неверно указан срок действия карты")).shouldBe(Condition.visible, Duration.ofSeconds(20));
    }

    public void errorMessageByIncorrectFormatYearField() {
        $(byText("Истёк срок действия карты")).shouldBe(Condition.visible, Duration.ofSeconds(20));
    }
}