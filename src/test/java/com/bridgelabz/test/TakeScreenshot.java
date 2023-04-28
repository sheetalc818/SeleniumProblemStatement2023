package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class TakeScreenshot extends BaseClass {

    @BeforeTest
    public void init(){
        setUp();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void takeScreenshotOfApp() throws IOException {
        TakesScreenshot src =(TakesScreenshot) driver;
        File srcShot = src.getScreenshotAs(OutputType.FILE);
        File destShot = new File("C:\\Users\\Admin\\Documents\\QADevPrograms\\CFP216AutomationProjects\\Screenshot\\fb3.jpeg");
        FileHandler.copy(srcShot,destShot);
        //FileUtils.copyFile(srcShot,destShot);
    }

    @Test
    public void screenshotOdSpecificWebElement() {
        WebElement emailShot = driver.findElement(By.id("email"));
        File srcShot = emailShot.getScreenshotAs(OutputType.FILE);
        File destShot = new File("C:\\Users\\Admin\\Documents\\QADevPrograms\\CFP216AutomationProjects\\Screenshot\\fb3.jpeg");
        try {
            FileHandler.copy(srcShot,destShot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

