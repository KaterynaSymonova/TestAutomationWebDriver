package com.epam.step;

import com.epam.fileattach.FileAttach;
import com.epam.singleton.driver.SingletonWebDriver;
import com.epam.webdriver.pages.*;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Kateryna_Symonova on 10/9/2015.
 */
public class Steps {
    private WebDriver driver;
    private StartPage startPage;
    private HomePage homePage;
    private SettingsForwardingPage settingsForwardPage;
    private NewMessagePage newMessagePage;
    private String subject;
    private FiltersPage filtersPage;
    private ThemesPage themePage;
    private GeneralSettingsPage mailSignaturePage;


    public Steps() {
        this.driver = SingletonWebDriver.getWebDriverInstance();
    }

    public static void closeDriver () {
        SingletonWebDriver.closeWebBrowser();
    }

    public void loginUser (String login,String password){
        startPage = new StartPage(driver);
        startPage.openPage();
        homePage =  startPage.loginUserAndReturnHomePage(login, password);

    }

    public void relogin (String login,String password){
        driver = SingletonWebDriver.restartWebDriver();
        loginUser(login, password);

    }

    public void clickNewMessage (){
        newMessagePage = homePage.clickNewMessage();
    }

    public void sendDefaultMessage (String toEmail) {
        clickNewMessage();
        subject = newMessagePage.sendSimpleTestMessage(toEmail);
    }

    public void sendMessageWithAttach (String to,String path ) throws IOException, InterruptedException, AWTException {
        clickNewMessage();
        newMessagePage.sendSimpleTestMessageWithAttach(to,path);

    }

    public void searchLetterBySubject () {
        homePage.findMessageBySubject(subject);
    }

    public void fillMessage (String email) {
       subject =  newMessagePage.fillFieldsDefault(email);
    }

    public void markMessageSpam () {
        homePage.markSpam(subject);
    }
//испарвить логику
    public boolean checkMessageInFolderSpam () {
        homePage.checkEmailForSpam(subject);
        return true;
    }

    public  void goToSettingsForward (){
        settingsForwardPage = homePage.goToSettingsForwarding();
    }

    public  void setForward(String email) {
        settingsForwardPage.addForward(email);
    }

    public  void acceptForward () {
        homePage.acceptForwarding();

    }

    public void clickForwardAndCopy () {
        settingsForwardPage.clickRadioButtonForwardAndCopy();
    }

    public void goToTabFilter(){
        filtersPage = homePage.goToSettingsFilter();
    }

    public void createFilter (String usermail){
        filtersPage.createFilter(usermail);
    }

    public void clickAttach (){
        newMessagePage.getAttach().click();
    }

    public void addFile(String path) throws AWTException, InterruptedException {
        FileAttach.uploadFile(path);

    }

    public boolean checkSizeAttach (){
        return homePage.checkWarningSizeAttach();

    }

    public void clickSettings () {
        homePage.clickSettings();
    }

    public void clickContextSettings (){
        homePage.clickContextSettings();
    }

    public void goToThemesSettings () {
       themePage = homePage.settingsTheme();
    }

    public void changeBackgroundImage () throws InterruptedException {
        themePage.choseMyPhoto();
    }

    public void choseUploadPhotos (){
        themePage.uploadPhoto();
    }

    public void pushSelectPhotoFromYourComputer () {
        themePage.selectCustomPhoto();

    }

    public boolean checkWarningTheme () {
        return themePage.checkWarning();

    }

    public void clickSendMessage () {
        newMessagePage.clickSend();
    }

    public void clickEmotionsBtn () {
        newMessagePage.clickEmoticons();
    }

    public void choseEmotions () {
        newMessagePage.choseEmoticons();
    }

    public boolean checkLetterContainsEmoticon () {
        searchLetterBySubject();
        homePage.clickFirstLetter();
        return homePage.checkEmoticon();

    }
    public  void getThemesPage () {
        themePage = homePage.getThemePage();
    }

    public void choseTheme () {
        themePage.choseThemeBeach();
    }

    public void goToSignaturePage () {
        homePage.clickContextSettings();
        mailSignaturePage = new GeneralSettingsPage(driver);
    }

    public void setSignature (String signature) {
        mailSignaturePage.setSignature(signature);
    }

    public void saveSignature () {
        mailSignaturePage.clickSave();
    }
    public boolean checkSignature (String signature) {
        return newMessagePage.checkSignature(signature);
    }

    public  void markLetterStarred () {
        homePage.markStarred();
    }

    public void goToForwardPage () {
        clickSettings();
        clickContextSettings();
        goToSettingsForward();
    }

}
