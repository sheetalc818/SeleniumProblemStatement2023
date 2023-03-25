package com.bridgelabz.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class FrameHandling {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/home");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/a")).click();
        driver.findElement(By.id("email-or-phone")).sendKeys("sanjuu5737@gmail.com");
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("abhishek@123");
        Thread.sleep(500);
        driver.findElement(By.id("join-form-submit")).click();
        Thread.sleep(500);
        driver.findElement(By.id("first-name")).sendKeys("Sanjay");
        driver.findElement(By.id("last-name")).sendKeys("Mishra");
        WebElement clickButton = driver.findElement(By.id("join-form-submit"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", clickButton);

        executor.executeScript("alert('Welcome on Frame');");

//        driver.switchTo().frame(0);
//        driver.findElement(By.name("phoneNumber")).sendKeys("7038053684");

        //identify total number of iframes present on the webpage
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.print("Total Frames --"+size);

        // finding out the index of iframe.
        for(int i=0; i<=size; i++){
            driver.switchTo().frame(i);
            int total = driver.findElements(By.xpath("//iframe[@src='/checkpoint/challengeIframe/AQFm5tqEQYL3tgAAAYaS6Fu74EITQOBQOfquo-ZjIyNmoaEXn2BCq2uD5IKpukf4f_hjPvxM_wfL97JNmfNxsc6eD7mgvQ?ut=1-QPZ1EwhtDaE1']")).size();
            System.out.println(total);
            driver.findElement(By.name("phoneNumber")).sendKeys("7038053684");
            driver.switchTo().defaultContent();
        }
        driver.close();
    }
}
