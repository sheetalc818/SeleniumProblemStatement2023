package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorsDemo extends BaseClass {

    @Test
    public void demoLocators() throws InterruptedException {
        WebElement phoneNumber = driver.findElement(By.id("deftphnumber"));
        phoneNumber.sendKeys("7856878");

        driver.findElement(By.tagName("input"));

        driver.findElement(By.name("ContactNumber")).sendKeys("Sheetal");

        driver.findElement(By.cssSelector("input#deftusername")).sendKeys("sheetalc818");

        WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[6]/div[2]/div[2]/div[2]/div[1]/input[1]"));
        Thread.sleep(500);
        element.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(500);
        element.click();

        driver.findElement(By.xpath("//input[@name='passoutYear']")).click();

        driver.findElement(By.className("anchor-tag")).click();

        String title = driver.getTitle();
        Assert.assertEquals("BridgeLabz: Guaranteed Emerging Tech Job",title);

        String pageSource = driver.getPageSource();
        System.out.println("PageSource : "+pageSource);

        System.out.println("Current page url : "+driver.getCurrentUrl());
//        WebElement element = driver.findElement(By.linkText("Gradle"));
//        Thread.sleep(500);
//        element.sendKeys(Keys.PAGE_DOWN);
//        element.click();
//        Thread.sleep(1000);

//        WebElement element1 = driver.findElement(By.partialLinkText("Forgotten"));
//        Thread.sleep(500);
//        element1.click();
//        Thread.sleep(1000);

    }
}
