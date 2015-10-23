package com.epam.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Kateryna_Symonova on 10/6/2015.
 */
public class StartPage extends AbstractPage {
    private static final String URL = "http://gmail.com";
    //private String email;
    private WebDriver webDriver;
    @FindBy(id = "Email")
    private WebElement login;

    @FindBy(id = "Passwd")
    private WebElement password;

    @FindBy(id = "next")
    private WebElement buttonNext;
    @FindBy(id = "signIn")
    private WebElement buttonSingIn;

    public StartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void openPage () {
        webDriver.get(URL);
    }

    public void loginUser (String login,String pass) {
        this.login.sendKeys(login);
        this.buttonNext.click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        password.sendKeys(pass);
        buttonSingIn.click();

    }

    public HomePage loginUserAndReturnHomePage (String login,String pass) {
        loginUser(login,pass);
        return new HomePage(webDriver);

    }



}
