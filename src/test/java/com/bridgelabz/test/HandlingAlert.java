package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandlingAlert extends BaseClass {
    @Test
    public void handleAlertPopup() throws InterruptedException {
        // Alert Message handling
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage = driver.switchTo().alert().getText();

        // Displaying alert message
        System.out.println(alertMessage);
        Thread.sleep(5000);

        // Accepting alert
        alert.accept();
        //driver.switchTo( ).alert( ).dismiss();
        //driver.switchTo().alert().sendKeys("Text");
    }
}
