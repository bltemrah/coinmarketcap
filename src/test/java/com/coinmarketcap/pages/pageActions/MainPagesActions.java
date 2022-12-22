package com.coinmarketcap.pages.pageActions;

import com.coinmarketcap.pages.commons.CommonActions;
import com.coinmarketcap.pages.pageLocators.MainPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPagesActions extends CommonActions {

    MainPageLocators mainPageLocators;

    public MainPagesActions() {
        mainPageLocators = new MainPageLocators();
    }

    public void closePopUp() {
        clickButton(mainPageLocators.closePopUp);
    }

    public void showRows() {
        clickButton(mainPageLocators.showRows);
    }

    public void twenty() {
        clickButton(mainPageLocators.twenty);
    }

    public void filter() {
        clickButton(mainPageLocators.filter);
    }

    public void algorithm() {
        clickButton(mainPageLocators.algorithm);
    }

    public void pow() {
        clickButton(mainPageLocators.pow);
    }

    public void addFilter() {
        clickButton(mainPageLocators.addFilter);
    }

    public void mineable() {
        clickButton(mainPageLocators.mineable);
    }

    public void allCrypto() {
        clickButton(mainPageLocators.allcrypto);
    }

    public void coins() {
        try {
            clickButtonWithoutWait(mainPageLocators.coins);
        } catch (WebDriverException e) {
            clickButton(mainPageLocators.allcrypto);
            clickButton(mainPageLocators.coins);
        }
    }

    public void price() {
        clickButton(mainPageLocators.price);
    }

    public void min(String min) {
        enterText(mainPageLocators.min, min);
    }

    public void max(String max) {
        enterText(mainPageLocators.max, max);
    }

    public void applyFilter() {
        clickButton(mainPageLocators.applyFilter);
    }

    public void showResults() {
        clickButton(mainPageLocators.showResults);
    }

    public void closeMaybeLater() {
        var element = getListOfElement(mainPageLocators.maybeLater);
        if (element.size() > 0) {
            clickButton(mainPageLocators.maybeLater);
        }
    }

    public String printTable() {
        WebElement table = driver.findElement(mainPageLocators.table);
        String wholeTable = table.getText();
        return wholeTable;
    }

    public List<String > getAllHeaders() {
        List<String> headers = getListOfText(mainPageLocators.tableHeader);
        System.out.println("Number of columns " + headers.size());

        for (String header : headers) {
            System.out.println(header);
        }
        return headers;
    }

    public void getHeadersSize() {
        List<WebElement> headers = driver.findElements(By.cssSelector("table.cmc-table th"));
        System.out.println("Number of columns " + headers.size());
    }

    public int getNumberOfRows() {
        List<WebElement> allRows = driver.findElements(mainPageLocators.tableRow);
        return allRows.size();
    }

    public List<String> getAllRowNames() {
        List<String> allRows = getListOfText(mainPageLocators.nameRow);
        return allRows;
    }
}