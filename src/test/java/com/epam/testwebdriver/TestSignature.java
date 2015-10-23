package com.epam.testwebdriver;

import com.epam.step.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Kateryna_Symonova on 10/19/2015.
 */
public class TestSignature {
    private Steps steps;
    private final String login = "testautomationuser1";
    private final String password = "kf,fhfnjhbz";
    private final String SIGNATURE = "Best regards";

    @BeforeTest
    public  void singIn () {
        steps = new Steps();
        steps.loginUser(login, password);
    }
    @Test
    public void testSignature () {
        steps.clickSettings();
        steps.goToSignaturePage();
        steps.setSignature(SIGNATURE);
        steps.saveSignature();
        steps.clickNewMessage();
        Assert.assertEquals(steps.checkSignature(SIGNATURE), true);

    }
    @AfterTest
    public void closeDriver() {
        steps.closeDriver();
    }


}
