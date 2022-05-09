package ru.praktikum;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Переход в личный кабинет, Переход из личного кабинета в конструктор, Выход из аккаунта")
public class AccountTest extends BaseTest {
    public UserOperations userOperations;
    public Map<String, String> userData;
    MainPage mainPage;

    @Before
    public void setup() {
        userOperations = new UserOperations();
        userData = userOperations.register();
        mainPage = page(MainPage.class);
        Assert.assertTrue("Страница 'Соберите бургер' не открылась", mainPage.checkVisibleTitleAssembleBurger());
        mainPage.clickLinkPersonalAccount();
        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.setFieldEmail(userData.get("email"));
        loginPage.setFieldPassword(userData.get("password"));
        loginPage.clickButtonEnter();

        mainPage = page(MainPage.class);
        Assert.assertTrue("Страница 'Соберите бургер' авторизованного пользователя не открылась", mainPage.checkVisibleButtonPlaceOrder());
    }

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();
    }

    @Test
    @DisplayName("Transfer to your personal account")
    @Description("Переход в личный кабинет")
    public void transferYourPersonalAccount() {
        mainPage.clickLinkPersonalAccount();
        Assert.assertTrue("Страницы личного кабинета не открыта", $(byXpath("//*[contains(@value, '" + userData.get("name") + "')]")).hover().is(Condition.visible));
    }

    @Test
    @DisplayName("Switching from your personal account to the constructor")
    @Description("Переход из личного кабинета в конструктор")
    public void transitionBuilder() {
        mainPage.clickLinkPersonalAccount();
        Assert.assertTrue("Страницы личного кабинета не открыта", $(byXpath("//*[contains(@value, '" + userData.get("name") + "')]")).hover().is(Condition.visible));
        mainPage.clickLinkBuilder();
        Assert.assertTrue("Страница 'Соберите бургер' авторизованного пользователя не открылась", mainPage.checkVisibleButtonPlaceOrder());
    }

    @Test
    @DisplayName("Switching from your personal account to the constructor by clicking on the logo")
    @Description("Переход из личного кабинета в конструктор нажатием на логотип")
    public void transitionBuilderClickLogo() {
        mainPage.clickLinkPersonalAccount();
        Assert.assertTrue("Страницы личного кабинета не открыта", $(byXpath("//*[contains(@value, '" + userData.get("name") + "')]")).hover().is(Condition.visible));
        mainPage.clickLinkLogo();
        Assert.assertTrue("Страница 'Соберите бургер' авторизованного пользователя не открылась", mainPage.checkVisibleButtonPlaceOrder());
    }

    @Test
    @DisplayName("Log out of your account")
    @Description("Выход из аккаунта")
    public void logoutAccount() {
        mainPage.clickLinkPersonalAccount();
        Assert.assertTrue("Страницы личного кабинета не открыта", $(byXpath("//*[contains(@value, '" + userData.get("name") + "')]")).hover().is(Condition.visible));
        AccountProfilePage accountProfilePage = page(AccountProfilePage.class);
        accountProfilePage.clickButtonLogout();
        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
    }
}
