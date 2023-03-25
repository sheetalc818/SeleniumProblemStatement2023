package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class SelectClassDemo extends BaseClass {

    public Select dropDown;
    @BeforeMethod
    public void launchBrowser(){
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void navigateOnFacebookLoginScreen_Success() throws IOException {
        String title = driver.getTitle();
        Assert.assertEquals(title,"Facebook – log in or sign up");
        //takeScreenshot();
    }

    @Test
    public void redirectOnToFbScreen_IdDisplayedImg() throws IOException {
        boolean flag = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]")).isDisplayed();
        Assert.assertTrue(flag);
        //takeScreenshot();
    }

    @Test
    public void createScreen() throws InterruptedException, IOException {
        driver.findElement(By.partialLinkText("Create ")).click();
        Thread.sleep(2000);

        WebElement dayDropDown = driver.findElement(By.name("birthday_day"));
        dropDown = new Select(dayDropDown);
        dropDown.selectByVisibleText("1");
        Thread.sleep(1000);

        WebElement monthDropDown = driver.findElement(By.id("month"));
        dropDown = new Select(monthDropDown);
        dropDown.selectByIndex(0);
        Thread.sleep(1000);

        WebElement yearDropDown = driver.findElement(By.name("birthday_year"));
        dropDown = new Select(yearDropDown);
        dropDown.selectByValue("1995");
        Thread.sleep(1000);


       driver.findElements(By.name("sex")).get(0).click();
//        List<WebElement> gender = driver.findElements(By.name("sex"));
//        System.out.println("Size of the list : "+gender.size());
//        for (int i=0;i<gender.size();i++){
//            //gender.get(i).click();
//            if (i==0){
//                gender.get(0).click();
//            }
//        }
        boolean flag = driver.findElements(By.name("sex")).get(0).isSelected();
        if (flag == true){
            System.out.println("Female Radio button Selected");
        }
        else {
            driver.findElements(By.name("sex")).get(0).click();
        }
        //takeScreenshot();
    }

}
