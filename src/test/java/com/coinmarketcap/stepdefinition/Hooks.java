package com.coinmarketcap.stepdefinition;

import com.coinmarketcap.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;


public class Hooks {

    @Before
    public void setup () {
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void close() {
        Driver.get().close();
    }

}
