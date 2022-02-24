package com.cybertek.test.day13_pom;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.test.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

@Test

    public void Test1(){
    LoginPage loginPage = new LoginPage();

 /*   String username = ConfigurationReader.get("username");
    String password = ConfigurationReader.get("_password");

    loginPage.login(username,password);
    Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

    String subtitle = "//h1[@class='oro-subtitle']";
    WebElement sub = driver.findElement(By.xpath(subtitle));
    Assert.assertEquals(sub.getText(),"Quick Launchpad");*/

    loginPage.loginAsDriver();

    String expectedSubtitle = "Quick Launchpad";

    DashboardPage dashboardPage = new DashboardPage();

    String actualSubtitle = dashboardPage.getPageSubTitle();

    Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitle");

    dashboardPage.navigateToModule("Activities","Calendar Events");

    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    BrowserUtils.waitFor(2);

    Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify subtitle Calendar Events");





}

}
