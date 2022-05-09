package ru.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends NavBarPage {

    public final SelenideElement titleAssembleBurger = $(By.xpath(".//h1[text() = 'Соберите бургер']"));
    public final SelenideElement buttonLoginAccount = $(By.xpath(".//button[contains(text(), 'Войти в аккаунт')]"));
    public final SelenideElement buttonPlaceOrder = $(By.xpath(".//button[contains(text(), 'Оформить заказ')]"));
    public final SelenideElement buttonBun = $(By.xpath(".//span[contains(text(), 'Булки')]/.."));
    public final SelenideElement buttonSauce = $(By.xpath(".//span[contains(text(), 'Соусы')]/.."));
    public final SelenideElement buttonFilling = $(By.xpath(".//span[contains(text(), 'Начинки')]/.."));
    public final SelenideElement labelBun = $(By.xpath(".//h2[contains(text(), 'Булки')]"));
    public final SelenideElement labelSauce = $(By.xpath(".//h2[contains(text(), 'Соусы')]"));
    public final SelenideElement labelFilling = $(By.xpath(".//h2[contains(text(), 'Начинки')]"));


    @Step("Проверяем виден ли заголовок 'Соберите бургер'")
    public boolean checkVisibleTitleAssembleBurger() {
        return titleAssembleBurger.hover().is(Condition.visible);
    }

    @Step("Нажатие кнопки 'Войти в аккаунт'")
    public void clickButtonLoginAccount() {
        buttonLoginAccount.click();
    }

    @Step("Нажатие кнопки 'Оформить заказ'")
    public void clickButtonPlaceOrder() {
        buttonPlaceOrder.click();
    }

    @Step("Проверяем видна ли кнопка 'Оформить заказ'")
    public boolean checkVisibleButtonPlaceOrder() {
        return buttonPlaceOrder.hover().is(Condition.visible);
    }

    @Step("Нажатие кнопки 'Булки'")
    public void clickButtonBun() {
        buttonBun.click();
    }

    @Step("Нажатие кнопки 'Соусы'")
    public void clickButtonSauce() {
        buttonSauce.click();
    }

    @Step("Нажатие кнопки 'Начинки'")
    public void clickButtonFilling() {
        buttonFilling.click();
    }

    @Step("Проверяем отображается ли в меню категория 'Булки'")
    public boolean checkVisibleLabelBun() {
        return labelBun.hover().is(Condition.visible);
    }

    @Step("Проверяем отображается ли в меню категория 'Соусы'")
    public boolean checkVisibleLabelSauce() {
        return labelSauce.hover().is(Condition.visible);
    }

    @Step("Проверяем отображается ли в меню категория 'Начинки'")
    public boolean checkVisibleLabelFilling() {
        return labelFilling.hover().is(Condition.visible);
    }

    public SelenideElement getTitleAssembleBurger() {
        return titleAssembleBurger;
    }

    public SelenideElement getButtonLoginAccount() {
        return buttonLoginAccount;
    }

    public SelenideElement getButtonPlaceOrder() {
        return buttonPlaceOrder;
    }

    public SelenideElement getButtonBun() {
        return buttonBun;
    }

    public SelenideElement getButtonSauce() {
        return buttonSauce;
    }

    public SelenideElement getButtonFilling() {
        return buttonFilling;
    }

    public SelenideElement getLabelBun() {
        return labelBun;
    }

    public SelenideElement getLabelSauce() {
        return labelSauce;
    }

    public SelenideElement getLabelFilling() {
        return labelFilling;
    }
}
