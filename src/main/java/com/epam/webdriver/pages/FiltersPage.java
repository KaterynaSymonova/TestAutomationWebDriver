package com.epam.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kateryna_Symonova on 10/13/2015.
 */
public class FiltersPage extends AbstractPage {
    private WebDriver driver;

    @FindBy (xpath = "//span[contains(text(),'Create a new filter')]")
    private WebElement createNewFilter;

    @FindBy (xpath = "//input [@class = 'ZH nr aQa']")
    private WebElement fromFilter;

    @FindBy (xpath= "//label [contains (text(),'Has attachment')]")
    private WebElement checkBoxHasAttachment;

    @FindBy (xpath = "//div[@class = 'acM']")
    private WebElement clickNext;

    @FindBy (xpath = "//div[@class = 'nH lZ']/label[contains (text(),'Delete it')]")
    private WebElement checkBoxDeleteIt;

    @FindBy (xpath = "//div[@class = 'nH lZ']/label[contains (text(),'Always mark it as important')]")
    private WebElement  checkBoxMarkItAsImportant ;

    @FindBy (xpath = "//div [@class = 'T-I J-J5-Ji Zx acL T-I-atl L3']")
    private WebElement  createFilterButton ;


    public FiltersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void createFilter(String userMail){
        createNewFilter.click();
        fromFilter.sendKeys(userMail);
        clickCheckBox(checkBoxHasAttachment);
        clickNext.click();
        clickCheckBox(checkBoxDeleteIt);
        clickCheckBox(checkBoxMarkItAsImportant);
        createFilterButton.click();
    }


    public void clickCheckBox (WebElement checkBox) {
        if (!checkBox.isSelected()){
        checkBox.click();
        }
    }
}
