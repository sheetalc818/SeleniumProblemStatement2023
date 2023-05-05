package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class AlertsPopUpHandling extends BaseClass {
    @Test
    public void simple_Alert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.id("alertButton")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
    }
    @Test
    public void simple_alert2() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(5000);
        Alert alert =driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    @Test
    public void Conforemation_PopUp() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        driver.findElement(By.id("confirmButton")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }
    @Test
    public void Prompt_PopUp() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        JavascriptExecutor jsexe = (JavascriptExecutor)driver;
        jsexe.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Mythili");
        alert.accept();
    }
    @Test
    public void Alert_Box() {
        driver.get("https://nxtgenaiacademy.com/alertandpopup/");
        driver.manage().window().maximize();
        driver.findElement(By.name("alertbox")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    @Test
    public void Confirm_Alert_Box() {
        driver.get("https://nxtgenaiacademy.com/alertandpopup/");
        driver.manage().window().maximize();
        driver.findElement(By.name("confirmalertbox")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    @Test
    public void Prompt_Alert_Box() throws InterruptedException {
        driver.get("https://nxtgenaiacademy.com/alertandpopup/");
        driver.findElement(By.name("promptalertbox1234")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("yes");
        Thread.sleep(2000);
        alert.accept();
    }
}
