package com.cybertek.cyTrakHW;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.test.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.ConfigurationReader2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyVyTrackHW extends TestBase {


    @Test
    public void testCase1(){

        extentLogger = report.createTest("VyTrack HW Test");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader2.get("salesmanager_username");
        String password = ConfigurationReader2.get("salesmanager_password");
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        calenderEventsPage calenderEventsPage = new calenderEventsPage();
        Assert.assertEquals(calenderEventsPage.getOptions().getText(),"Options");
        Assert.assertTrue(calenderEventsPage.getOptions().isDisplayed(),"Verify is displayed");


    }





}
