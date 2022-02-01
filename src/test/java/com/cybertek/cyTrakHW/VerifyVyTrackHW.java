package com.cybertek.cyTrakHW;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.test.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.ConfigurationReader2;
import com.cybertek.utilities.Driver;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.Dictionary;
import java.util.List;

public class VerifyVyTrackHW extends TestBase {


    @Test
    public void testCase1(){

//        1. Go to “https://qa1.vytrack.com/"
//        2. Login as a store manager
//        3. Navigate to “Activities -> Calendar Events”
//        4. Verify that page subtitle "Options" is displayed


//        1. Go to “https://qa1.vytrack.com/"
        LoginPage loginPage = new LoginPage();

//        2. Login as a store manager
        String username = ConfigurationReader2.get("salesmanager_username");
        String password = ConfigurationReader2.get("salesmanager_password");
        loginPage.login(username,password);

//        3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

//        4. Verify that page subtitle "Options" is displayed
        calenderEventsPage calenderEventsPage = new calenderEventsPage();
        Assert.assertEquals(calenderEventsPage.getOptions().getText(),"Options");
        Assert.assertTrue(calenderEventsPage.getOptions().isDisplayed(),"Verify is displayed");



    }

    @Test
    public void test2() throws InterruptedException {

//        1. Go to “https://qa1.vytrack.com/"
//        2. Login as a store manager
//        3. Navigate to “Activities -> Calendar Events”
//        4. Verify that page number is equals to "1"


//        1. Go to “https://qa1.vytrack.com/"
        LoginPage loginPage = new LoginPage();

//        2. Login as a store manager
        String username = ConfigurationReader2.get("storemanager_username");
        String password = ConfigurationReader2.get("storemanager_password");
        loginPage.login(username,password);

//        3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

//        4. Verify that page number is equals to "1"
        calenderEventsPage calenderEventsPage = new calenderEventsPage();
        BrowserUtils.waitForClickablility(calenderEventsPage.checkPageNumber(),12);
        Assert.assertEquals(calenderEventsPage.checkPageNumber().getAttribute("value"),"1","verify page number is 1");
        System.out.println(calenderEventsPage.checkPageNumber().getAttribute("type"));

    }
    @Test
    public void test3() throws InterruptedException {

//        1. Go to “https://qa1.vytrack.com/"
//        2. Login as a store manager
//        3. Navigate to “Activities -> Calendar Events”
//        4. Verify that view per page number is equals to "25"


//        1. Go to “https://qa1.vytrack.com/"
        LoginPage loginPage = new LoginPage();

//        2. Login as a store manager
        String username = ConfigurationReader2.get("storemanager_username");
        String password = ConfigurationReader2.get("storemanager_password");
        loginPage.login(username, password);

//        3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

//        4. Verify that view per page number is equals to "25"
        calenderEventsPage calenderEventsPage = new calenderEventsPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        Assert.assertEquals(calenderEventsPage.checkDropDownNumber().getText(), "25", "verify number is 25");
    }

        @Test

        public void test4() throws InterruptedException {

//            Test case #4
//            1. Go to “https://qa1.vytrack.com/"
//            2. Login as a store manager
//            3. Navigate to “Activities -> Calendar Events”
//            4. Verify that number of calendar events (rows in the table) is equals to number of records


//            Hint: In HTML, <table> tag represents table,<thread> - table header, <tr> tag represents table row element,
//            <th> table header cell and <td> table data.


//            1. Go to “https://qa1.vytrack.com/"
            LoginPage loginPage = new LoginPage();

//            2. Login as a store manager
            String username = ConfigurationReader2.get("storemanager_username");
            String password = ConfigurationReader2.get("storemanager_password");
            loginPage.login(username, password);

//            3. Navigate to “Activities -> Calendar Events”
            DashboardPage dashboardPage = new DashboardPage();
            dashboardPage.waitUntilLoaderScreenDisappear();
            dashboardPage.navigateToModule("Activities", "Calendar Events");
            dashboardPage.waitUntilLoaderScreenDisappear();

//            4. Verify that number of calendar events (rows in the table) is equals to number of records
            calenderEventsPage calenderEventsPage = new calenderEventsPage();
            dashboardPage.waitUntilLoaderScreenDisappear();
            calenderEventsPage.checkDropDownNumber().click();
            BrowserUtils.waitForClickablility(calenderEventsPage.button(),3);
            calenderEventsPage.button().click();
            Thread.sleep(5000);

            String a = calenderEventsPage.totalNumberOf().getText();
            String [] b = a.split(" ");
            String totalNumberOf = b[2];
            int ab=Integer.parseInt(totalNumberOf);


            List<WebElement> rows = Driver.get().findElements(By.xpath("//tbody/tr"));
            int rowNumbers = rows.size();
            String expectedRows = String.valueOf(rowNumbers);

            Assert.assertEquals(ab,rowNumbers,"verify are they equals");
        }

        @Test

        public void test5() throws InterruptedException {

//         1. Go to “https://qa1.vytrack.com/"
//         2. Login as a store manager
//         3. Navigate to “Activities -> Calendar Events”
//         4. Click on the top checkbox to select all
//         5. Verify that all calendar events were selected


//         1. Go to “https://qa1.vytrack.com/"
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader2.get("storemanager_username"), ConfigurationReader2.get("storemanager_password"));

//         2. Login as a store manager
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

//         3. Navigate to “Activities -> Calendar Events”
        calenderEventsPage calenderEventsPage= new calenderEventsPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

//         4. Click on the top checkbox to select all
        calenderEventsPage.checkbox.click();
        Thread.sleep(2000);

//         5. Verify that all calendar events were selected
        List<WebElement> rows = Driver.get().findElements(By.xpath("//tbody/tr"));
        int rowNumbers = rows.size();

        List<WebElement> checkboks = Driver.get().findElements(By.xpath("//input[@tabindex='-1']"));

        for (WebElement checkbok : checkboks) {
        Assert.assertTrue(checkbok.isSelected(),"is selected");
        }


    }

        @Test

        public void test6(){

//            1. Go to “https://qa1.vytrack.com/"
//            2. Login as a store manager
//            3. Navigate to “Activities -> Calendar Events”
//            4. Select “Testers meeting”
//            5. Verify that following data is displayed:


//            1. Go to “https://qa1.vytrack.com/"
            LoginPage loginPage = new LoginPage();

//            2. Login as a store manager
            loginPage.login(ConfigurationReader2.get("storemanager_username"), ConfigurationReader2.get("storemanager_password"));

//            3. Navigate to “Activities -> Calendar Events”
            DashboardPage dashboardPage = new DashboardPage();
            dashboardPage.waitUntilLoaderScreenDisappear();
            dashboardPage.navigateToModule("Activities", "Calendar Events");
            dashboardPage.waitUntilLoaderScreenDisappear();

//            4. Select “Testers meeting”
            calenderEventsPage calenderEventsPage= new calenderEventsPage();
            dashboardPage.waitUntilLoaderScreenDisappear();
            calenderEventsPage.testerMeeting.click();
            dashboardPage.waitUntilLoaderScreenDisappear();



//            5. Verify that following data is displayed:
//            Assert.assertEquals(calenderEventsPage.title.getText(),ConfigurationReader2.get("Titles"));
//            Assert.assertEquals(calenderEventsPage.start.getText(),ConfigurationReader2.get("Start"));
//            Assert.assertEquals(calenderEventsPage.end.getText(),ConfigurationReader2.get("End"));
//            Assert.assertEquals(calenderEventsPage.all_day_event.getText(),"No");
//            Assert.assertEquals(calenderEventsPage.organizers.getText(),ConfigurationReader2.get("Organizer"));
//            Assert.assertEquals(calenderEventsPage.call.getText(),"No");
//            Assert.assertEquals(calenderEventsPage.description.getText(), ConfigurationReader2.get("Description"));

            List<WebElement> information = Driver.get().findElements(By.xpath("//div[@class='control-label'][1]"));

              Assert.assertEquals(information.get(0).getText(),ConfigurationReader2.get("Titles"));
              Assert.assertEquals(information.get(1).getText(),ConfigurationReader2.get("Start"));
              Assert.assertEquals(information.get(2).getText(),ConfigurationReader2.get("End"));
              Assert.assertEquals(information.get(3).getText(),"No");
              Assert.assertEquals(information.get(4).getText(),ConfigurationReader2.get("Organizer"));
              Assert.assertEquals(information.get(5).getText(),"No");
              Assert.assertEquals(calenderEventsPage.description.getText(), ConfigurationReader2.get("Description"));

            for (WebElement webElement : information) {
                Assert.assertTrue(webElement.isDisplayed());
                System.out.println("YES");
            }

            Assert.assertTrue(calenderEventsPage.description.isDisplayed());









        }


}
