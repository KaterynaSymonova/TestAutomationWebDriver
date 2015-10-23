package com.epam.webdriver.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by Kateryna_Symonova on 10/8/2015.
 */
public class SettingsForwardingPage extends AbstractPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'aos T-I-J3 J-J5-Ji']")
    private WebElement viewSettings ;

    @FindBy(id = "ms")
    private WebElement contextSettings;

    @FindBy (partialLinkText = "Forwarding and POP/IMAP")
    private WebElement forwardingandPOPIMAP;

    @FindBy(xpath = "//input [@act = 'add']")
    private WebElement addForwardBtn ;

    @FindBy (xpath = "//input[@name = 'sx_em' and @value = '1']")
    private WebElement radiobuttonForwardAndCopy;

    @FindBy(xpath = "//div[@class = 'rU']/button[@guidedhelpid = 'save_changes_button']")

    private WebElement buttonSaveChanges;




    public SettingsForwardingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }


    public void addForward(String email){
        addForwardBtn.click();
        WebElement addNew = driver.switchTo().activeElement();
        addNew.sendKeys(email);
        addNew.findElement(By.xpath("//button[@name='next']")).click();
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handles.toArray(new String[handles.size()])[1]);
        System.out.println(handles.toArray(new String[handles.size()])[1]);
        WebElement proceed= driver.findElement(By.xpath("//input [@value = 'Proceed']"));
        proceed .click();

    }

    public void clickRadioButtonForwardAndCopy () {
        if (!radiobuttonForwardAndCopy.isSelected()) {
            radiobuttonForwardAndCopy.click();
        }
        //WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonSaveChanges));
        buttonSaveChanges.click();
    }
}
