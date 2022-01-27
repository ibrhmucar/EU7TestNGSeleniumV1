package com.cybertek.cyTrakHW;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class calenderEventsPage {

    public WebElement getOptions(){

        String path = "//div[@class='btn btn-link dropdown-toggle']";

        return Driver.get().findElement(By.xpath(path));
    }

}
