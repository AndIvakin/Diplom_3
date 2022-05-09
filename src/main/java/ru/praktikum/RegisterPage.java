package ru.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class RegisterPage extends NavBarPage {

    public final SelenideElement titleRegister = $(By.xpath(".//h2[text() = 'Регистрация']"));
    public final SelenideElement fieldName = $(By.xpath(".//label[text() = 'Имя']/../input"));
    public final SelenideElement fieldEmail = $(By.xpath(".//label[text() = 'Email']/../input"));
    public final SelenideElement fieldPassword = $(By.xpath(".//label[text() = 'Пароль']/../input"));
    public final SelenideElement buttonRegister = $(By.xpath(".//button[text() = 'Зарегистрироваться']"));
    public final SelenideElement labelErrorFieldPassword = $(By.xpath(".//p[contains(@class, 'error')]"));
    public final SelenideElement linkLogin = $(By.xpath(".//a[contains(text(), 'Войти')]"));

    @Step ("Проверяем виден ли заголовок 'Регистрация'")
    public boolean checkVisibleTitleRegister(){
        return titleRegister.hover().is(Condition.visible);
    }

    @Step("Заполняем поле 'Имя'")
    public void setFieldName(String name) {
        fieldName.sendKeys(name);
    }

    @Step("Заполняем поле 'Email'")
    public void setFieldEmail(String email) {
        fieldEmail.sendKeys(email);
    }

    @Step("Заполняем поле 'Пароль'")
    public void setFieldPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    @Step("Нажатие ссылки 'Зарегистрироваться'")
    public void clickButtonRegister(){
        buttonRegister.click();
    }

    @Step ("Проверяем видна ли сообщение 'Некорректный пароль'")
    public boolean checkVisibleLabelErrorFieldPassword(){
        return labelErrorFieldPassword.hover().is(Condition.visible);
    }

    @Step("Нажатие ссылки 'Войти'")
    public void clickButtonLogin(){
        linkLogin.click();
    }

    public SelenideElement getTitleRegister() {
        return titleRegister;
    }

    public SelenideElement getFieldName() {
        return fieldName;
    }

    public SelenideElement getFieldEmail() {
        return fieldEmail;
    }

    public SelenideElement getFieldPassword() {
        return fieldPassword;
    }

    public SelenideElement getButtonRegister() {
        return buttonRegister;
    }

    public SelenideElement getLabelErrorFieldPassword() {
        return labelErrorFieldPassword;
    }

    public SelenideElement getLinkLogin() {
        return linkLogin;
    }
}
