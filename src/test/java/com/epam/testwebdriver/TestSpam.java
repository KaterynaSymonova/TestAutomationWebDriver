package com.epam.testwebdriver;


import com.epam.singleton.driver.SingletonWebDriver;
import com.epam.step.Steps;
import com.epam.webdriver.pages.HomePage;
import com.epam.webdriver.pages.NewMessagePage;
import com.epam.webdriver.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Kateryna_Symonova on 10/6/2015.
 */
public class TestSpam {
    private Steps steps;

    @BeforeTest
    public void createStepClass() {
        steps = new Steps();
    }

    @Parameters({"login","password","login2","password2","email"})
    @Test
    public  void testSpam (String login,String password,String email,String login2,String password2) {
        steps.loginUser(login, password);
        steps.sendDefaultMessage(email);
        steps.relogin(login2, password2);
        steps.markMessageSpam();
        steps.relogin(login, password);
        steps.sendDefaultMessage(email);
        steps.relogin(login2, password2);
        steps.checkMessageInFolderSpam();
        Assert.assertEquals(steps.checkMessageInFolderSpam(),true);
    }

    @AfterTest
    public void closeDriver (){
        Steps.closeDriver();
    }

}
