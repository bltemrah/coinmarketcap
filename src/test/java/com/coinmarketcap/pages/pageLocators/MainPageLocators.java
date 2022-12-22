package com.coinmarketcap.pages.pageLocators;

import org.openqa.selenium.By;

public class MainPageLocators {

    public By closePopUp = By.cssSelector("svg.jhvPQd");

    public By showRows = By.cssSelector(".table-control-page-sizer svg");

    public By twenty = By.cssSelector(".dropdown-container>button:nth-child(3)");

    public By filter = By.cssSelector("div>button.table-control-filter");

    public By algorithm = By.cssSelector("li.filter:nth-child(2) button");

    public By pow = By.xpath("//*[text()=\"PoW\"]");

    public By addFilter = By.xpath("//*[text()=\"+\"]");

    public By mineable = By.cssSelector("#mineable:nth-child(2)");

    public By allcrypto = By.cssSelector("div.filter-area>div:nth-child(1)>button");

    public By coins = By.cssSelector("div.cmc-option-container:nth-child(2) button.cmc-option-button");

    public By price = By.xpath("(//*[text()=\"Price\"])[1]");

    public By min = By.cssSelector("[data-qa-id='range-filter-input-min']");

    public By max = By.cssSelector("[data-qa-id='range-filter-input-max']");

    public By applyFilter = By.xpath("(//*[text()=\"Apply Filter\"])[1]");

    public By maybeLater = By.xpath("//*[text()=\"Maybe later\"]");

    public By table = By.cssSelector("table.cmc-table");

    public By tableHeader = By.cssSelector("table.cmc-table th");

    public By tableRow = By.cssSelector("table tbody>tr");

    public By nameRow = By.cssSelector("table tbody>tr>td:nth-child(3)");

    public By showResults = By.xpath("//*[text()=\"Show results\"]");
    public By coinName = By.cssSelector("tbody>tr td div.name-area>p");
    public By coinPosition = By.cssSelector("tbody>tr>td:nth-child(2)>p");
    public By coinPrice = By.cssSelector("tbody>tr>td:nth-child(4) span");


}
