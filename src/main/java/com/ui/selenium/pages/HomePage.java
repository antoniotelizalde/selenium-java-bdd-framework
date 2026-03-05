package com.ui.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By categoriesButton = By.cssSelector("[data-testid = 'blt26617d4f2e17657d-header-button-category']");
    private final By womanOption = By.xpath("//a[@data-testid='blt26617d4f2e17657d-header-menu-categories-menu-category-item-']");
    private final By jacketsOptions = By.xpath("//span[contains(text(), 'Chamarras')]");
    private final By imageJacket = By.xpath("//img[contains(@alt,'Chamarra cazadora Aéropostale para mujer')]");
    private final By gButton = By.xpath("//button[contains(text(), 'G')]");
    private final By carButton = By.xpath("//button[contains(text(), 'Agregar a mi bolsa')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectCategories() {
        click(categoriesButton);
    }

    public void selectWoman() {
        mouseHover(womanOption);
    }

    public void selectJackets() {
        click(jacketsOptions);
    }

    public void selectImageJacket() {
        click(imageJacket);
    }

    public void selectGButton() {
        click(gButton);
    }

    public void selectAddCarButton() {
        click(carButton);
    }
}
