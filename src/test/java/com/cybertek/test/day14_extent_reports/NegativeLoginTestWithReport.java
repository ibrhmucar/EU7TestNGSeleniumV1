package com.cybertek.test.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.test.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        extentLogger = report.createTest("Wrong Password Test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username: username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("username"));

        extentLogger.info("Enter Password : somempass");
        loginPage.passwordInput.sendKeys("somepass");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page Url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test Pass");
    }

    @Test
    public void wrongUsernameTest(){

        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter Username: User1");
        loginPage.usernameInput.sendKeys("User1");

        extentLogger.info("Enter Password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click to Login Button");
        loginPage.loginBtn.click();


        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/loginQQ");

        extentLogger.pass("PASSED");
    }




}
