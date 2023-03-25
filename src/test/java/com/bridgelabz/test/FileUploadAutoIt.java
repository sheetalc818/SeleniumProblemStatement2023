package com.bridgelabz.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.awt.*;
import java.io.IOException;

public class FileUploadAutoIt {
    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.freepdfconvert.com/pdf-to-word");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/main/div[1]/div/div/div[2]/section/label/div/div[1]/a/span")).click();


        //AutoIT Script
        Runtime.getRuntime().exec("D:\\AutoITScript\\CFPUpload.exe");
        System.out.println("File uploaded Successfully");
    }
}
