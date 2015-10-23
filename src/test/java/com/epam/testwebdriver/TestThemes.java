package com.epam.testwebdriver;

import com.epam.step.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by Kateryna_Symonova on 10/16/2015.
 */
public class TestThemes {
    private Steps steps;
    private final String login = "testautomationuser1";
    private final String password = "kf,fhfnjhbz";
    private final String PATH_TO_FILE = "C:\\Users\\Kateryna_Symonova\\Desktop\\Worksheet 4.docx";

    @BeforeTest
    public  void singIn () {
        steps = new Steps();
        steps.loginUser(login, password);
    }

    @Test
    public void testSetCustomThemes() throws InterruptedException, AWTException {

        steps.goToThemesSettings();
        steps.changeBackgroundImage();
        steps.choseUploadPhotos();
        steps.addFile(PATH_TO_FILE);
        Assert.assertEquals(steps.checkWarningTheme(), true);
    }

    @Test
    public void testInsetTheme() {
        steps.clickSettings();
        steps.clickContextSettings();
        steps.getThemesPage();
        steps.choseTheme();
       // Assert.assertEquals();

    }

    @AfterTest
    public void closeDriver() {
        steps.closeDriver();
    }




}
