package com.weborders.pages;

import com.weborders.utilities.BrowserUtils;
import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//h1[contains(text(),'Web Orders')]")
    public WebElement pageSubtitle;

    @FindBy(tagName = "h1")
    private WebElement pageLogo;

    /* Returns list of web-elements */
    @FindBy(tagName = "th")
    private List<WebElement> columnNamesElements;

    public void navigateTo(String moduleName){
        Driver.getDriver().findElement(By.linkText(moduleName)).click();
    }

    public List<String> getColumnNames() {
        return BrowserUtils.getListOfString(columnNamesElements);
    }
}
