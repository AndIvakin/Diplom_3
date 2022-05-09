package ru.praktikum;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

class BaseTest {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String ACCOUNT_PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    @Before
    public void testConfig() {
        Configuration.timeout = 5000;
        WebDriverManager.chromedriver().setup();
        //Configuration.browserBinary = "C:\\Users\\*******\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
        Configuration.browserSize = "1920x1080";
        open(BASE_URL);
    }
}
