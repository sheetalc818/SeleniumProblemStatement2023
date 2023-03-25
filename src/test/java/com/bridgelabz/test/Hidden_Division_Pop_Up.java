package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Hidden_Division_Pop_Up extends BaseClass {
    @Test
    public void hidden_PopUp() throws InterruptedException {
        driver.get("https://www.cleartrip.com/");
        driver.findElement(By.xpath("//path[@d='M18 6L12 12M12 12L6 18M12 12L6 6M12 12L18 18']")).click();
        driver.findElement(By.xpath("//div[text()='Sat, Jul 9']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='24']")).click();
        Thread.sleep(2000);
    }
}
