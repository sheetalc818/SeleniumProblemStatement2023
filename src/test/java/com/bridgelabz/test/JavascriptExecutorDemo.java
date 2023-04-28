package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class JavascriptExecutorDemo extends BaseClass {
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Epic("Initial Demo")
    public void demo() throws InterruptedException {
        driver.get(properties.getProperty("jsDemoGuruWebsite1"));

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
    @Severity(SeverityLevel.BLOCKER)
    public void facebookLogin_Success() throws InterruptedException {
        driver.get(properties.getProperty("jsDemoFbWebsite"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.id(properties.getProperty("fbSuccessUserNLocator"))).sendKeys("testingtestdatablz@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("testing123");
        WebElement loginBtn = driver.findElement(By.name("login"));
        js.executeScript("arguments[0].click()",loginBtn);
        Thread.sleep(3000);

        String homeTitle = driver.getTitle();
        Assert.assertEquals("(3) Facebook",homeTitle);
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,400)"); // down vertical scroll
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,-400)"); // up vertical scroll

        js.executeScript("alert('Logged in successfully');");
        //driver.switchTo().alert().sendKeys("gfgfg");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void javascriptExecutorScroll() throws InterruptedException {
        driver.get(properties.getProperty("jsDemoGuruWebsite2"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath(properties.getProperty("jsExScrollElementXpath")));
        executor.executeScript("arguments[0].scrollIntoView();",element);

        executor.executeScript("window.scrollBy(0,-250)");

        //executor.executeScript("window.scrollBy(250,0)");

        WebElement linkElement = driver.findElement(By.linkText("https://demo.guru99.com/V4/"));
        executor.executeScript("arguments[0].click();",linkElement);
        String parentWindowAddress = driver.getWindowHandle();
        System.out.println("Parent Window Address : "+parentWindowAddress);

        Set<String> allWidows =  driver.getWindowHandles();
        System.out.println("No of windows present : "+allWidows.size());

        Iterator<String> iterator = allWidows.iterator();
        while (iterator.hasNext()){
            String childWindow = iterator.next();
            if(!parentWindowAddress.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                WebElement enterUser = driver.findElement(By.name("uid"));
                executor.executeScript("arguments[0].setAttribute('value', '\" longstring \"')",enterUser);
                //driver.close();
            }
        }

    }
}
