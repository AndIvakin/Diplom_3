package ru.praktikum;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavBarPage {

    public final SelenideElement linkBuilder = $(By.xpath(".//p[contains(text(), 'Конструктор')]/.."));
    public final SelenideElement linkOrderList = $(By.xpath(".//p[contains(text(), 'Лента Заказов')]/.."));
    public final SelenideElement linkPersonalAccount = $(By.xpath(".//p[contains(text(), 'Личный Кабинет')]/.."));
    public final SelenideElement linkLogo = $(By.xpath(".//div[contains(@class, 'logo')]//a"));

    @Step("Нажатие кнопки 'Конструктор'")
    public void clickLinkBuilder(){
        linkBuilder.click();
    }

    @Step("Нажатие кнопки 'Лента Заказов'")
    public void clickLinkOrderList(){
        linkOrderList.click();
    }

    @Step("Нажатие кнопки 'Личный кабинет'")
    public void clickLinkPersonalAccount(){
        linkPersonalAccount.click();
    }

    @Step("Нажатие на лого 'Stellar Burders'")
    public void clickLinkLogo(){
        linkLogo.click();
    }

}
