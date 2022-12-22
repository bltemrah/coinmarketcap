package com.coinmarketcap.pages.commons;

import com.coinmarketcap.driver.Driver;
import com.coinmarketcap.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonActions {
    protected WebDriver driver;

    public CommonActions () {
        driver = Driver.get();
    }

    public WebDriverWait waitFor () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofMillis(200));
        return wait;
    }

    public void openPage () {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    public void clickButton (By locator) {

        waitFor().until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void enterText (By locator, String text) {

        waitFor().until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public List<String> getListOfText(By locator) {

        List<WebElement> elements = driver.findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elements) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public List<WebElement> getListOfElement (By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }

    public void clickButtonWithoutWait(By locator) {
        driver.findElement(locator).click();
    }
}
