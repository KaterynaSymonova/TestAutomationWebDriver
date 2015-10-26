package com.epam.testwebdriver;

import com.epam.step.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by Kateryna_Symonova on 10/19/2015.
 */
public class TestEmoticons {
    private Steps steps;

    @Parameters({"login","password","email"})
    @BeforeTest
    public  void singIn (String login,String password) {
        steps = new Steps();
        steps.loginUser(login, password);
    }

    @Test
    public void testEmoticon(String email)  {
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
