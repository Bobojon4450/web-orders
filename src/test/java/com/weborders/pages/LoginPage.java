package com.weborders.pages;

import com.weborders.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "ctl00_MainContent_username")
    private WebElement userNameInputElement;

    @FindBy(id ="ctl00_MainContent_password")
    private WebElement passwordInputElement;

    public void login(){
        String userName = ConfigurationReader.getProperty("user_name");
        String password = ConfigurationReader.getProperty("password");
        userNameInputElement.sendKeys(userName);
        passwordInputElement.sendKeys(password, Keys.ENTER);
    }

    public void login(String username, String password){
        userNameInputElement.sendKeys(username);
        passwordInputElement.sendKeys(password, Keys.ENTER);
    }




}
