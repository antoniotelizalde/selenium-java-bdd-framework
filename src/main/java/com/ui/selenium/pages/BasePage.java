package com.ui.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor js;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    protected WebElement waitForView(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new AssertionError("element not visible " + locator, e);
        }
    }

    protected WebElement waitForClickable(By locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            throw new AssertionError("element not clickable " + locator, e);
        }
    }

    protected void click(By locator) {
        try {
            waitForClickable(locator).click();
        } catch (ElementClickInterceptedException e) {
            scrollIntoView(locator);
            waitForClickable(locator).click();
        } catch (WebDriverException e) {
            throw new AssertionError("click failed on: " + locator, e);
        }
    }

    protected void type(By locator, String text) {
        try {
            WebElement element = waitForView(locator);
            element.clear();
            element.sendKeys(text);
        } catch (WebDriverException e) {
            throw new AssertionError("type failed on: " + locator + "with the text" + text, e);
        }
    }

    protected String getText(By locator) {
        return waitForView(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return waitForView(locator).isDisplayed();
        } catch (AssertionError e) {
            return false;
        }
    }

    protected void scrollDown(By locator) {
        js.executeScript("window.scroolBy(0, arguments[0]);", locator);
    }

    protected void scrollUp(By locator) {
        js.executeScript("window.scroolBy(0, -arguments[0]);", locator);
    }

    protected void scrollIntoView(By locator) {
        WebElement element = waitForView(locator);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    protected void jsClick(By locator) {
        WebElement element = waitForView(locator);
        js.executeScript("arguments[0].click();", element);
    }

    protected void mouseHover(By locator) {
        WebElement element = waitForView(locator);
        actions.moveToElement(element).perform();
    }
}