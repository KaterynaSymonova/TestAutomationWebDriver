package com.epam.webdriver.pages;

import com.epam.fileattach.FileAttach;
import com.epam.message.Message;
import com.epam.message.StaticMessageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Kateryna_Symonova on 10/7/2015.
 */
public class NewMessagePage extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class= 'wO nr l1']/textarea [@class = 'vO'] ")
    private WebElement to;

    @FindBy(xpath= "//div[@class = 'aoD az6']/input[@class = 'aoT']")
    private WebElement subject;

    @FindBy(xpath = "//div[@class = 'Am Al editable LW-avf']")
    private WebElement textOfMessage;

    @FindBy(xpath = "//div[@class = 'T-I J-J5-Ji aoO T-I-atl L3']")
    private WebElement buttonSend;

    @FindBy(xpath = "//div[@class = 'a1 aaA aMZ']")
    private WebElement attach;

    public WebElement getAttach() {
        return attach;
    }

    @FindBy(xpath = "//div[@class = 'QT aaA aMZ']")
    private WebElement emoticonBtn;

    //@FindBy(xpath = "//div[@class = 'wVboN']")
    private WebElement emoticonWindow;


    public NewMessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);


    }
    public String sendSimpleTestMessageWithAttach (String email,String pathFile ) throws IOException, AWTException, InterruptedException {
        Message message = StaticMessageFactory.getEmptyMessage(email);
        to.sendKeys(message.getTo());
        subject.sendKeys(message.getSubject());
        textOfMessage.sendKeys(message.getText());
        attach.click();
        FileAttach.uploadFile(pathFile);
       // WebDriverWait wait = new WebDriverWait(driver,10,1000 );
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'dL']/input[@name = 'attach']")));
        buttonSend.click();
        return message.getSubject();
    }

    public String sendSimpleTestMessage (String toEmail){
        String subject = fillFieldsDefaultAndReturnSubjeck(toEmail);
        buttonSend.click();
        return subject;
    }

    public String fillFieldsDefault (String email) {
        Message message = StaticMessageFactory.getDefaultMessage(email);
        to.sendKeys(message.getTo());
        subject.sendKeys(message.getSubject());
        textOfMessage.sendKeys(message.getText());
        return message.getSubject();
    }
    public String fillFieldsDefaultAndReturnSubjeck (String email) {
        Message message = StaticMessageFactory.getDefaultMessage(email);
        to.sendKeys(message.getTo());
        subject.sendKeys(message.getSubject());
        textOfMessage.sendKeys(message.getText());
        return message.getSubject();
    }

    public void clickEmoticons () {
        emoticonBtn.click();
    }

    public void choseEmoticons () {
        emoticonWindow = driver.findElement(By.xpath("//button[@string = '1f605']"));
        emoticonWindow.click();
    }

    public void clickSend () {
        buttonSend.click();
    }

    public boolean checkSignature (String signature) {
        WebElement trSignature = driver.findElement(By.xpath("//div[@class = 'gmail_signature']/div[@dir = 'ltr']"));
        if (trSignature.getText().contentEquals(signature)){ //contains(signature)){
            return true;
        }
        return false;
    }



}
