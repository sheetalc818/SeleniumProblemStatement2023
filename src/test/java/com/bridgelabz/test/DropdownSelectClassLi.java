package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

public class DropdownSelectClassLi extends BaseClass {

    public static Logger log = Logger.getLogger(DropdownSelectClassLi.class.getName());

    @Test
    public void handleDropdownUsingSelectForList() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        log.info("Launched Website");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[text() = 'Group 2, option 1']")).click();
        Thread.sleep(500);

        WebElement oldStyleDropdown = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldStyleDropdown);
        //select.selectByVisibleText("Purple");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,500)");
        //select.selectByValue("4");
        select.selectByIndex(4);
        Thread.sleep(2000);

        List<WebElement> listDropdown = select.getOptions();
        for (int i = 0 ; i< listDropdown.size() ; i++){
            System.out.println("List : " + listDropdown.get(i).getText());
        }

    }
}
