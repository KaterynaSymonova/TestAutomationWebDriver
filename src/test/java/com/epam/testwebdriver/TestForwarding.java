package com.epam.testwebdriver;

import com.epam.step.Steps;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Kateryna_Symonova on 10/7/2015.
 */
public class TestForwarding {
    private Steps steps;
    private String login = "testautomationuser1";
    private String password = "kf,fhfnjhbz";
    private String email = "testautomationuser1@gmail.com";
    private String login2 = "testautomationuser2";
    private String password2 = "kf,fhfnjhbz";
    private String email2 = "testautomationuser2@gmail.com";
    private String login3 = "testautomationuser3";
    private String password3 = "kf,fhfnjhbz";
    private String email3 = "testautomationuser3@gmail.com";
    public final static String PATH_TO_FILE = "C:\\Users\\Kateryna_Symonova\\Desktop\\Worksheet 4.docx";

    @BeforeTest
    public void createStepClass() {
        steps = new Steps();
    }

    @Test
    public   void testAddForward() throws IOException, AWTException, InterruptedException {
//        steps.loginUser(login2,password2);
//        steps.clickSettings();
//        steps.clickContextSettings();
//        steps.goToSettingsForward();
//        steps.setForward(email3);
//        steps.relogin(login3, password3);
//        steps.acceptForward();
        steps.relogin(login2, password2);
        steps.goToForwardPage();
        steps.clickForwardAndCopy();
        steps.goToTabFilter();
        steps.createFilter(email);
        steps.relogin(login, password);
        steps.sendMessageWithAttach(email2,PATH_TO_FILE);
        steps.sendDefaultMessage(email2);
        //steps.sendDefaultMessage(email2);
        steps.relogin(login2,password2);







}

    @AfterTest
    public void closeDriver (){
       Steps.closeDriver();
    }

}
