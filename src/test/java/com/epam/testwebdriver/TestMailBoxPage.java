package com.epam.testwebdriver;

import com.epam.step.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by Kateryna_Symonova on 10/15/2015.
 */
public class TestMailBoxPage {
    private String login = "testautomationuser1";
    private String password = "kf,fhfnjhbz";
    private String email = "testautomationuser2@gmail.com";
    public final static String PATH_TO_FILE = "C:\\Users\\Kateryna_Symonova\\Desktop\\test.wmv";

    private Steps steps;
    @BeforeTest
    public  void singIn () {
        steps = new Steps();
        steps.loginUser(login, password);
    }

    @Test
    public void testAttachBigFile () throws InterruptedException, AWTException {
        steps.clickNewMessage();
        steps.fillMessage(email);
        steps.clickAttach();
        steps.addFile(PATH_TO_FILE);
        Assert.assertEquals(steps.checkSizeAttach(), true);

    }

    @AfterTest
    public void closeDriver() {
        steps.closeDriver();
    }
}
