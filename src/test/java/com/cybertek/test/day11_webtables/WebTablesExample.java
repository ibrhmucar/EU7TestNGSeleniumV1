package com.cybertek.test.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(1350, 0));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod

    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void printTable() {

        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));

    }

    @Test
    public void getAllHeaders() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());

        }

        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("elements.size() = " + allRowsWithHeader.size());

        for (WebElement element : allRowsWithHeader) {
            System.out.println(element.getText());
        }

        List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("allRowsWithoutHeaders.size() = " + allRowsWithoutHeaders.size());

        for (WebElement allRowsWithoutHeader : allRowsWithoutHeaders) {
            System.out.println(allRowsWithoutHeader.getText());
        }
    }

    @Test

    public void getrow() {
        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));

        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= numRows.size(); i++) {

            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
            System.out.println(i + "-" + row.getText());
        }

//***loop shortcuts iter and itar

    }

    @Test

    public void getAllCellInOneRow() {

        List<WebElement> row2 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        for (WebElement webElement : row2) {
            System.out.println(webElement.getText());
        }
    }


    @Test

    public void getASingleCellByIndex() {

        WebElement url = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[5]"));
        System.out.println(url.getText());

        WebElement mail = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));
        System.out.println(mail.getText());

    }

    @Test

    public void prinAllCell(){
    int rowNumber = getNumberOfRows();
    int columnsNumber = getNumberOfColumns();


        for(int i = 1; i <= rowNumber ;i++) {
        for (int j = 1; j <= columnsNumber; j++) {
            String xpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
            WebElement result = driver.findElement(By.xpath(xpath));
            System.out.println(result.getText());
        }

    }

}

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String firstname = "Jason";

        String xpath = "//table[@id='table1']//td[.='"+firstname+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());





    }



        private int getNumberOfColumns () {
            List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
            return headers.size();
        }
        private int getNumberOfRows () {
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
            return rows.size();
        }
    }













