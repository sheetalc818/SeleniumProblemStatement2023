package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstScript extends BaseClass {

    @Test
    public void webinarScreen() throws InterruptedException {
        driver.get("https://bldev.bridgelabz.com/webinar");
        WebElement phoneText = driver.findElement(By.cssSelector("div.material-textfield"));
        System.out.println("text :"+phoneText.getText());

        boolean flag = driver.findElement(By.name("ContactNumber")).isDisplayed();
        if(flag)
        {
            driver.findElement(By.name("ContactNumber")).sendKeys("678899999");
        }

        List<WebElement> elements = driver.findElements(By.xpath("//div"));
        System.out.println("No. of elements : "+elements.size());
        for (int i=0; i<elements.size(); i++){
           System.out.println("Element Text :" +elements.get(i).getAttribute("value"));
        }

        WebElement element = driver.findElement(By.name("passoutYear"));
        Thread.sleep(1000);
        element.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(1000);
        element.click();Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@value='2021']")).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deftdegree")));
        //element1.click();
       // System.out.println("Text : "+element1.getText());
        driver.close();

    }
}
