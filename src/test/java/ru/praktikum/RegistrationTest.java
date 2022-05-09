package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static ru.praktikum.UserOperations.EMAIL_POSTFIX;

@DisplayName("Регистрация")
public class RegistrationTest extends BaseTest {
    MainPage mainPage;
    private String email;
    private String password;

    @After
    public void tearDown() {
        UserOperations userOperations = new UserOperations();
        userOperations.authorizationUserForGetToken(email, password);
        userOperations.delete();
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Successful user Authorization")
    @Description("Успешная авторизация пользователя")
    public void successfulUserAuthorization() {
        mainPage = page(MainPage.class);
        Assert.assertTrue("Страница 'Соберите бургер' не открылась", mainPage.checkVisibleTitleAssembleBurger());
        mainPage.clickLinkPersonalAccount();

        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.clickButtonRegister();

        RegisterPage registerPage = page(RegisterPage.class);
        email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
        password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        registerPage.setFieldName(name);
        registerPage.setFieldEmail(email);
        registerPage.setFieldPassword(password);
        registerPage.clickButtonRegister();

        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.setFieldEmail(email);
        loginPage.setFieldPassword(password);
        loginPage.clickButtonEnter();

        Assert.assertTrue("Страница 'Соберите бургер' авторизованного пользователя не открылась", mainPage.checkVisibleButtonPlaceOrder());
    }

    @Test
    @DisplayName("Entering an incorrect password during registration")
    @Description("Ввод не корректного пароля при регистрации")
    public void enteringIncorrectPasswordDuringRegistration() {
        mainPage = page(MainPage.class);
        Assert.assertTrue("Страница 'Соберите бургер' не открылась", mainPage.checkVisibleTitleAssembleBurger());
        mainPage.clickButtonLoginAccount();

        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.clickButtonRegister();

        RegisterPage registerPage = page(RegisterPage.class);
        email = RandomStringUtils.randomAlphabetic(10) + EMAIL_POSTFIX;
        password = RandomStringUtils.randomAlphabetic(5);
        String name = RandomStringUtils.randomAlphabetic(10);
        registerPage.setFieldName(name);
        registerPage.setFieldEmail(email);
        registerPage.setFieldPassword(password);
        registerPage.clickButtonRegister();

        Assert.assertTrue("Отсутствует предупреждение 'Некорректный пароль'", registerPage.checkVisibleLabelErrorFieldPassword());
    }
}
