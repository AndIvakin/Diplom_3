package ru.praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.page;

@DisplayName("Раздел «Конструктор»")
public class BuilderTest extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Transitions to sections of the builder")
    @Description("Переходы к разделам конструктора")
    public void transitionsSectionsBuilder() {
        mainPage = page(MainPage.class);
        Assert.assertTrue("Страница 'Соберите бургер' не открылась", mainPage.checkVisibleTitleAssembleBurger());

        mainPage.clickButtonSauce();
        Assert.assertTrue("Переход меню к категории 'Соусы' не произведен", mainPage.checkVisibleLabelSauce());

        mainPage.clickButtonFilling();
        Assert.assertTrue("Переход меню к категории 'Начинки' не произведен", mainPage.checkVisibleLabelFilling());

        mainPage.clickButtonBun();
        Assert.assertTrue("Переход меню к категории 'Булки' не произведен", mainPage.checkVisibleLabelBun());
    }
}
