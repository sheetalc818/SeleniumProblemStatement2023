package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavascriptExecutorDemo extends BaseClass {
    @Test
    public void demo() throws InterruptedException {
        driver.get("https://www.guru99.com/api-testing.html");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        System.out.println("execute script : " + executor.executeScript("return window.length"));

        int noOfFrames = Integer.parseInt(executor.executeScript("return window.length").toString());
        System.out.println("No of frames : "+noOfFrames);

//        for (int i =0; i<=noOfFrames ; i++){
//            System.out.println("Frame Title : "+ driver.switchTo().frame(i).getTitle());
//        }
        executor.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(500);
    }

    @Test
    public void facebookLogin_Success() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.id("email")).sendKeys("testingtestdatablz@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("testing123");
        WebElement loginBtn = driver.findElement(By.name("login"));
        js.executeScript("arguments[0].click()",loginBtn);
        Thread.sleep(3000);

        String homeTitle = driver.getTitle();
        Assert.assertEquals("(4) Facebook",homeTitle);
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,400)"); // down vertical scroll
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-400)"); // up vertical scroll

        js.executeScript("alert('Logged in successfully');");
        driver.switchTo().alert().sendKeys("gfgfg");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
    }
}
