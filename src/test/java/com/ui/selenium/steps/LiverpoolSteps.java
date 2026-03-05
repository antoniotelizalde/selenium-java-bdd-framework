package com.ui.selenium.steps;

import com.ui.selenium.hooks.Hooks;
import com.ui.selenium.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LiverpoolSteps {

    private HomePage home;

    @Given("the user open the website")
    public void openWebsite() {
        Hooks.driver.get("https://www.liverpool.com.mx/");
        System.out.println("opening browser");
    }

    @And("select categories button")
    public void categoriesList() throws InterruptedException {
        home = new HomePage(Hooks.driver);
        home.selectCategories();
        Thread.sleep(3000);
    }

    @When("select woman option")
    public void womanOption() {
        home.selectWoman();
    }

    @And("select jackets")
    public void jacketOption() {
        home.selectJackets();
    }

    @And("select the first jacket")
    public void imageJacketOption() {
        home.selectImageJacket();
    }

    @And("select the G button")
    public void gOption() {
        home.selectGButton();
    }

    @And("select add to car")
    public void addCarOption() throws InterruptedException {
        home.selectAddCarButton();
        Thread.sleep(3000);
    }
}
