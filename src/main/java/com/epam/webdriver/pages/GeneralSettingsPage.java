package com.epam.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kateryna_Symonova on 10/19/2015.
 */
public class GeneralSettingsPage {
    private WebDriver driver;

    @FindBy (xpath = "//div[@class = 'Am Al editable Xp0HJf-LW-avf']")
    private WebElement textSignature;

    @FindBy (xpath = "//input [@id = ':8v']")
    private WebElement vacationResponderRadioButton;



    @FindBy (xpath = "//div[@class= 'rU']/button[contains (text(),'Save')]")
    private WebElement saveBtn;

    public GeneralSettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void setSignature (String signature) {
        textSignature.sendKeys(signature);
    }

    public void clickSave () {
        saveBtn.click();

    }

    public void choseVacationResponder (){
        vacationResponderRadioButton.click();
        
    }


}
