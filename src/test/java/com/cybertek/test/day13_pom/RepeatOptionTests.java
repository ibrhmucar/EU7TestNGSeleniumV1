package com.cybertek.test.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.test.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionTests extends TestBase {

    @Test

    public void Test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        createCalendarEventsPage.repeat.click();

        BrowserUtils.waitForClickablility(createCalendarEventsPage.days,3);
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"is checked");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"is unchecked");



    }


    @Test

    public void test2(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        createCalendarEventsPage.repeat.click();

        Select repeatsDropDown = createCalendarEventsPage.repeatOptionsList();
        Select repeat = createCalendarEventsPage.returnSelected(createCalendarEventsPage.repeatOptions);



        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<String> actualList = new ArrayList<>();

        List<WebElement> actualOptions = repeatsDropDown.getOptions();

        for (WebElement option : actualOptions) {
            actualList.add(option.getText());
        }

        Assert.assertEquals(actualList,expectedList,"verify two list is equal");


       // Second way;
       // List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);



    }
}
