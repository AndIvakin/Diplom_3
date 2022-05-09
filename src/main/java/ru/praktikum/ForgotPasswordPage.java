package ru.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage extends NavBarPage {

    public final SelenideElement titleForgotPassword = $(By.xpath(".//h2[text() = 'Восстановление пароля']"));
    public final SelenideElement linkLogin = $(By.xpath(".//a[contains(text(), 'Войти')]"));

    @Step ("Проверяем виден ли заголовок 'Регистрация'")
    public boolean checkVisibleTitleForgotPassword(){
        return titleForgotPassword.hover().is(Condition.visible);
    }

    @Step("Нажатие ссылки 'Войти'")
    public void clickButtonLogin(){
        linkLogin.click();
    }
}
