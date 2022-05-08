package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Вход")
@RunWith(Parameterized.class)
public class LoginUserTest extends BaseTest {

    private int numCase;
    public UserOperations userOperations;
    public Map<String, String> userData;
    MainPage mainPage;
    RegisterPage registerPage;

    public LoginUserTest(int numCase) {
        this.numCase = numCase;
    }

    @Parameterized.Parameters
    public static Object[][] getLoginData() {
        return new Object[][]{
                {1},
                {2},
                {3},
                {4},
        };
    }

    @Before
    public void setup() {
        userOperations = new UserOperations();
        userData = userOperations.register();
    }

    @After
    public void tearDown() {
        userOperations.delete();
        webdriver().driver().close();
    }

    @Test
    @DisplayName("User Login")
    @Description("Вход пользователя")
    public void userLogin() {
        switch (numCase) {
            case 1:
                mainPage = page(MainPage.class);
                Assert.assertTrue("Страница 'Соберите бургер' не открылась", mainPage.checkVisibleTitleAssembleBurger());
                mainPage.clickLinkPersonalAccount();
                break;
            case 2:
                mainPage = page(MainPage.class);
                Assert.assertTrue("Страница 'Соберите бургер' не открылась", mainPage.checkVisibleTitleAssembleBurger());
                mainPage.clickButtonLoginAccount();
                break;
            case 3:
                open(REGISTER_URL);
                registerPage = page(RegisterPage.class);
                Assert.assertTrue("Страница 'Регистрация' не открылась", registerPage.checkVisibleTitleRegister());
                registerPage.clickButtonLogin();
                break;
            case 4:
                open(FORGOT_PASSWORD_URL);
                ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
                Assert.assertTrue("Страница 'Восстановление пароля' не открылась", forgotPasswordPage.checkVisibleTitleForgotPassword());
                forgotPasswordPage.clickButtonLogin();
                break;
        }

        LoginPage loginPage = page(LoginPage.class);
        Assert.assertTrue("Страница 'Вход' не открылась", loginPage.checkVisibleTitleLogin());
        loginPage.setFieldEmail(userData.get("email"));
        loginPage.setFieldPassword(userData.get("password"));
        loginPage.clickButtonEnter();

        mainPage = page(MainPage.class);
        Assert.assertTrue("Страница 'Соберите бургер' авторизованного пользователя не открылась", mainPage.checkVisibleButtonPlaceOrder());
    }
}
