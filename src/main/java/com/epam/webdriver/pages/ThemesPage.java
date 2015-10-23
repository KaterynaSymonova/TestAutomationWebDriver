package com.epam.webdriver.pages;

import com.epam.fileattach.FileAttach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

/**
 * Created by Kateryna_Symonova on 10/16/2015.
 */
public class ThemesPage {

    private WebDriver driver;

    @FindBy (xpath = "//div[@class = 'Kj-JD a8j']")
    private WebElement alertDialogTheme;

    @FindBy (xpath = "//div[contains (text(),'My Photos')]")
    private WebElement myPhotoBtn;

    @FindBy(xpath =  "//div[@class = 'J-J5-Ji T-I T-I-atl']")
    private WebElement saveBtn;

    private WebElement selectYourBeckgroundImage;

    private WebElement uploadPhoto;
    private WebElement selectPhotoFromMyCompBtn;
    private WebElement warning;



    public ThemesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void choseMyPhoto() throws InterruptedException {
        WebElement webElement = driver.findElement(By.xpath("//div[@class = 'Kj-JD a8j']"));
        myPhotoBtn = webElement.findElement(By.xpath( "//*[contains (text(),'My Photos')]"));
        myPhotoBtn.click();

    }


    public void uploadPhoto () {
        driver.switchTo().frame(driver.findElement(By.className("KA-JQ")));
        uploadPhoto = driver.findElement(By.xpath("//div[contains (text(),'Upload a photo')]"));
        uploadPhoto.click();
        selectPhotoFromMyCompBtn = driver.findElement(By.xpath("//div[contains (text(),'Select a photo from your computer')]"));
        selectPhotoFromMyCompBtn.click();
    }

    public void selectCustomPhoto () {
        driver.switchTo().frame(driver.findElement(By.className("KA-JQ")));
        selectPhotoFromMyCompBtn = driver.findElement(By.xpath("//div[contains (text(),'Select a photo from your computer')]"));
        selectPhotoFromMyCompBtn.click();
    }

    public void addImage (String path) throws AWTException, InterruptedException {
        FileAttach.uploadFile(path);
        warning = driver.switchTo().frame(driver.findElement(By.className("KA-JQ"))).findElement(By.xpath("//div [@class = 'ag-hg-Gg-Nb']"));
    }

    public boolean checkWarning () {
        if (warning.getText().contains("is not supported")){
            return true;
        }return false;
    }

    public void choseThemeBeach () {
        WebElement themeBeach = driver.findElement(By.xpath("//div[@aria-label = 'Beach (by: iStockPhoto)']"));
        themeBeach.click();

    }


}
