package com.weborders.stepdefinitions;


import com.weborders.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void teardown(){
        Driver.close();
    }
}
