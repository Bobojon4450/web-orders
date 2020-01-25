package com.weborders.stepdefinitions;

import com.weborders.pages.BasePage;
import com.weborders.pages.LoginPage;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("I login as tester")
    public void i_login_as_tester() {
        loginPage.login();
    }

    @Then("verify that {string} logo is displayed")
    public void verify_that_logo_is_displayed(String string) {
        Assert.assertTrue(loginPage.pageSubtitle.isDisplayed());
        Assert.assertEquals(string, loginPage.pageSubtitle.getText());
    }
}
