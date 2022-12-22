package com.coinmarketcap.stepdefinition;

import com.coinmarketcap.pages.pageActions.MainPagesActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;

public class MainPageStepDefinitions extends MainPagesActions {

    @Given("open the coin market cap webpage")
    public void open_the_coin_market_cap_webpage() {
        openPage();
        closePopUp();
    }

    @When("set the coin table by twenty")
    public void set_the_coin_table_by_twenty() throws InterruptedException {
        showRows();
        twenty();
        Thread.sleep(2000);
    }

    @And("click Algorithm")
    public void clickAlgorithm() {
        filter();
        algorithm();
    }

    @Then("select the PoW")
    public void selectThePoW() {
        pow();
    }

    @And("click Add-filter")
    public void clickAddFilter() {
        addFilter();
    }

    @Then("toggle Mineable")
    public void toggleMineable() {
        mineable();
    }

    @And("click All Cryptocurrencies")
    public void clickAllCryptocurrencies() {
        allCrypto();
    }

    @Then("select Coins")
    public void selectCoins() throws InterruptedException {
        coins();
    }

    @Then("select price and set minimum value to {string} and maximum to {string}")
    public void selectPriceAndSetMinimumValueToAndMaximumTo(String min, String max) throws InterruptedException {
        price();
        min(min);
        max(max);
        applyFilter();
        showResults();

        Thread.sleep(3000);
    }

    @And("the filtered table should contain {string} and {string}")
    public void theFilteredTableShouldContainAnd(String arg0, String arg1) {
        Assert.assertTrue(printTable().contains(arg0));
        Assert.assertTrue(printTable().contains(arg1));
    }

    @Then("the table should contain {int} coins")
    public void theTableShouldContainCoins(int arg0) {
        Assert.assertEquals(getNumberOfRows(), arg0);
    }

    List<String> firstTableNameSelect;
    @Then("capture all coin names in the table")
    public void captureAllCoinNamesInTheTable() {
        firstTableNameSelect = getAllRowNames();
    }
    @And("the first filtered table should Not contain the coin names inside the second filtered table")
    public void theFirstFilteredTableShouldNotContainTheCoinNamesInsideTheSecondFilteredTable() {

        var secondTableNameSelect = getAllRowNames();

        boolean nameFlag = false;
        for (String name : secondTableNameSelect) {
            for (String coinName : firstTableNameSelect) {
                if (name.equals(coinName)) {
                    nameFlag = true;
                    break;
                }
            }
            Assert.assertFalse(nameFlag);

            if(nameFlag){
                System.out.println(name + " : is between £100 and £10000 and on the first filter table " );
            }else {
                System.out.println(name + " : is between £100 and £10000 but not on the first filter table " );
            }
        }
    }

    int sizeOfFirstTable;
    @Then("count the first table size")
    public void countTheFirstTableSize() {
        sizeOfFirstTable = getNumberOfRows();

    }
    int sizeOfSecondTable;
    @Then("coint the second table size")
    public void cointTheSecondTableSize() {

        sizeOfSecondTable = getNumberOfRows();
    }

    @And("the filtered table should contain coins less than the first filtered table")
    public void theFilteredTableShouldContainCoinsLessThanTheFirstFilteredTable() {

            Assert.assertTrue(sizeOfFirstTable>=sizeOfSecondTable);
    }

    List<String> firstTableHeaderNames;
    @Then("capture the first table headers")
    public void captureTheFirstTableHeaders() {

        firstTableHeaderNames = getAllHeaders();
    }

    List<String> secondTableHeaderNames;
    @Then("capture the second table headers")
    public void captureTheSecondTableHeaders() {

        secondTableHeaderNames = getAllHeaders();
    }

    @And("the filtered table should contain same header names with the first filtered table")
    public void theFilteredTableShouldContainSameHeaderNamesWithTheFirstFilteredTable() {

        boolean nameFlag = false;
        for (String name : secondTableHeaderNames) {

            for (String headerNames : firstTableHeaderNames) {
                if (name.equals(headerNames)) {
                    nameFlag = true;
                    break;
                }
            }
            Assert.assertTrue(firstTableHeaderNames.equals(secondTableHeaderNames));
        }
    }
}
