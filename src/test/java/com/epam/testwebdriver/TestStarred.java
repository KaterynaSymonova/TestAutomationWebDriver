package com.epam.testwebdriver;

import com.epam.step.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Kateryna_Symonova on 10/20/2015.
 */
public class TestStarred {
    private Steps steps;
    private final String login = "testautomationuser1";
    private final String password = "kf,fhfnjhbz";


    @BeforeTest
    public  void singIn () {
        steps = new Steps();
        steps.loginUser(login, password);
    }
    @Test
    public void testStarred () {
     steps.markLetterStarred();

    }
    @AfterTest
    public void closeDriver() {
        steps.closeDriver();
    }
}
