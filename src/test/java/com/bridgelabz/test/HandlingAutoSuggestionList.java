package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class HandlingAutoSuggestionList extends BaseClass {
    @Test
    public void handleAutoSuggestionList() throws InterruptedException {
        driver.get("https://www.google.com/");

        WebElement searchTextField = driver.findElement(By.name("q"));
        searchTextField.sendKeys("selenium");

        List<WebElement> listOfElements= driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
        Thread.sleep(500);
        int totalNoOfElements = listOfElements.size();

        System.out.println("No of Elements : "+totalNoOfElements);
        //listOfElements.get(2).click();
        Thread.sleep(1000);

        for (WebElement options : listOfElements){
            String text = options.getText();
            if(text.contains("selenium webdriver")){
                options.click();
                break;
            }
        }
    }

    @Test
    public void amazonApplicationSearchList(){
        driver.get("https://www.amazon.com/");

        WebElement searchTextField = driver.findElement(By.id("twotabsearchtextbox"));
        searchTextField.sendKeys("iphone");

        List<WebElement> listOfOptions = driver.findElements(By.xpath("//*[contains(text(),'iphone')]"));
        int totalNoOfOptions = listOfOptions.size();

        listOfOptions.get(3).click();
    }

    @Test
    public void gbBrowserBasedPopup() throws InterruptedException {
        driver.get("https://www.facebook.com/");

        driver.findElement(By.id("email")).sendKeys("testingtestdatablz@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("testing123");
        Thread.sleep(1000);
        driver.findElement(By.name("login")).click();
        Thread.sleep(10000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("alert('Welcome')");
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
