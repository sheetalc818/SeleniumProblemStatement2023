package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DatePicker extends BaseClass {

    @Test
    public void datePicker() throws InterruptedException {
    driver.get("http://demo.guru99.com/test/");

    //Find the date time picker control

    WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));

    //Fill date as mm/dd/yyyy as 03/25/2023

        dateBox.sendKeys("03252023");

    //Press tab to shift focus to time field

        dateBox.sendKeys(Keys.TAB);

    //Fill time as 02:45 PM

        dateBox.sendKeys("0245PM");
        Thread.sleep(1000);
    }
}




