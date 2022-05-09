package ru.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends NavBarPage {

    public final SelenideElement titleLogin = $(By.xpath(".//h2[text() = 'Вход']"));
    public final SelenideElement fieldEmail = $(By.xpath(".//label[text() = 'Email']/../input"));
    public final SelenideElement fieldPassword = $(By.xpath(".//label[text() = 'Пароль']/../input"));
    public final SelenideElement buttonEnter = $(By.xpath(".//button[contains(text(), 'Войти')]"));
    public final SelenideElement linkRegister = $(By.xpath(".//a[contains(text(), 'Зарегистрироваться')]"));

    @Step ("Проверяем виден ли заголовок 'Вход'")
    public boolean checkVisibleTitleLogin(){
        return titleLogin.hover().is(Condition.visible);
    }

    @Step("Заполняем поле 'Email'")
    public void setFieldEmail(String email) {
        fieldEmail.sendKeys(email);
    }

    @Step("Заполняем поле 'Пароль'")
    public void setFieldPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    @Step("Нажатие кнопки 'Войти'")
    public void clickButtonEnter(){
        buttonEnter.click();
    }

    @Step("Нажатие ссылки 'Зарегистрироваться'")
    public void clickButtonRegister(){
        linkRegister.click();
    }

    public SelenideElement getTitleLogin() {
        return titleLogin;
    }

    public SelenideElement getFieldEmail() {
        return fieldEmail;
    }

    public SelenideElement getFieldPassword() {
        return fieldPassword;
    }

    public SelenideElement getButtonEnter() {
        return buttonEnter;
    }

    public SelenideElement getLinkRegister() {
        return linkRegister;
    }
}
