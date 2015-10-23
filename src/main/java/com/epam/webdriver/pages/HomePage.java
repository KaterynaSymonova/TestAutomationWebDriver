package com.epam.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kateryna_Symonova on 10/7/2015.
 */
public class HomePage extends AbstractPage {

    public static final String MAIL_SETTINGS_GOOGLE_COM_MAIL = "mail-settings.google.com/mail";
    public static final String DIV_CLASS_Y6_SPAN_ID_3K = "//div [@class = 'y6']/span [@id = ':3k']";
    public static final String GMAIL_FORWARDING_CONFIRMATION = "Gmail Forwarding Confirmation";
    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'T-I J-J5-Ji T-I-KE L3']")
    private WebElement newMessage;

    @FindBy(xpath = "//span[@class = 'Dj']")
    private WebElement messageIsFound;

    @FindBy(partialLinkText = "Spam")
    private WebElement spamFolder;

    @FindBy(xpath = "//span[@class = 'CJ']")
    private WebElement moreBtn;

    @FindBy(xpath = "//div[@class = 'asl T-I-J3 J-J5-Ji']")
    private WebElement spamBtn;

    @FindBy(xpath = "//div[@class = 'T-Jo-auh']")
    private WebElement checkBox ;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchBySubject;

    @FindBy(xpath = "//span[@class = 'gbqfi gb_wb']")
    private WebElement searchBtn;

    @FindBy(xpath = "//div[@class = 'aos T-I-J3 J-J5-Ji']")
    private WebElement viewSettings ;

    @FindBy(id = "ms")
    private WebElement contextSettings;

    @FindBy (partialLinkText = "Forwarding and POP/IMAP")
    private WebElement forwardingandPOPIMAP;

    @FindBy(partialLinkText = "Filters and Blocked Addresses")
    private WebElement tabFilter;

    @FindBy(partialLinkText = "Themes")
    private WebElement tabThemes;

    @FindBy(id = "pbwc")
    private WebElement themesSettings;

    @FindBy(xpath = "//table [@class = 'F cf zt']")
    private WebElement tableOfLetter;

    private WebElement bodyLetter;


    private WebElement webElement;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public NewMessagePage clickNewMessage () {
        newMessage.click();
        return new NewMessagePage(driver);
    }

    public void markSpam(String subject){
        findMessageBySubject(subject);
        checkBox.click();
        spamBtn.click();

    }

    public void goToFolderSpam () {
        moreBtn.click();
        spamFolder.click();
    }

    public boolean checkEmailForSpam (String subject)   {
        goToFolderSpam();
        findMessageBySubject(subject);
        return true;
    }

    public void findMessageBySubject (String subject) {
        searchBySubject.sendKeys(subject);
        searchBtn.click();
    }

    public void acceptForwarding (){
        findMessageBySubject(GMAIL_FORWARDING_CONFIRMATION);
        WebElement messageForAccept = driver.findElement(By.xpath(DIV_CLASS_Y6_SPAN_ID_3K));
        messageForAccept.click();
        WebElement hrefAccept = driver.findElement(By.partialLinkText(MAIL_SETTINGS_GOOGLE_COM_MAIL));
        hrefAccept.click();
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handles.toArray(new String[handles.size()])[1]);
        WebElement confirm= driver.findElement(By.xpath("//input [@value = 'Confirm']"));
        confirm.click();

    }

    public void clickContextSettings() {
       // clickSettings();
        contextSettings.click();
    }

    public SettingsForwardingPage goToSettingsForwarding () {
        forwardingandPOPIMAP.click();
        return new SettingsForwardingPage(driver);

    }
    public FiltersPage goToSettingsFilter (){
        clickContextSettings();
        tabFilter.click();
        return new FiltersPage(driver);
    }

    public boolean checkWarningSizeAttach (){
        WebElement warning = driver.switchTo().activeElement().findElement(By.xpath("//div[@class = 'BGsnXd']"));
        return warning.isDisplayed();
    }

    public void clickSettings(){
        viewSettings.click();
    }

    public ThemesPage   settingsTheme () {
        viewSettings.click();
        themesSettings.click();
        return new ThemesPage(driver);

    }

    public ThemesPage getThemePage () {
        tabThemes.click();
        WebElement linkSetTheme = driver.findElement(By.xpath("//a[contains (text(),'Set')]"));
        linkSetTheme.click();
        return new ThemesPage(driver);
    }

    public void clickFirstLetter () {
        WebElement firstInList = driver.findElement(By.xpath("//table [@class = 'F cf zt']/tr [1]"));
        firstInList.click();

    }

    public boolean checkEmoticon () {
        try {
            bodyLetter = driver.findElement(By.xpath("//div [@dir= 'ltr']/img[@goomoji = '1f606']"));
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
     return true;
    }


    public void markStarred () {
        WebElement letter = driver.findElement(By.xpath("//table[@class = 'F cf zt']/tr[1]/td[3]"));
        letter.click();

    }

    /*public boolean isElementPresent(String subject) {

        return driver.findElements(By.xpath("//span[@b='"+subject+"']")).size()>0;
    }*/



}
