package com.epam.testwebdriver;

import com.epam.step.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by Kateryna_Symonova on 10/19/2015.
 */
public class TestEmoticons {
    private Steps steps;
    private final String login = "testautomationuser1";
    private final String password = "kf,fhfnjhbz";
    private final String email = "testautomationuser1@gmail.com";



    @BeforeTest
    public  void singIn () {
        steps = new Steps();
        steps.loginUser(login, password);
    }

    @Test
    public void testEmoticon()  {
        steps.clickNewMessage();
        steps.fillMessage(email);
        steps.clickEmotionsBtn();
        steps.choseEmotions();
        steps.clickSendMessage();
        Assert.assertEquals(steps.checkLetterContainsEmoticon(),true);


    }

    @AfterTest
    public void closeDriver() {
        steps.closeDriver();
    }

}
