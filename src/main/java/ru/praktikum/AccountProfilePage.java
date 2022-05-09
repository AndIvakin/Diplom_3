package ru.praktikum;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountProfilePage extends NavBarPage {

    public final SelenideElement buttonLogout = $(By.xpath(".//button[contains(text(), 'Выход')]"));

    @Step("Нажимаем кнопку 'Выход'")
    public void clickButtonLogout() {
        buttonLogout.click();
    }

    public SelenideElement getButtonLogout() {
        return buttonLogout;
    }
}