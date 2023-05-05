package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.List;

public class HandlingFrame extends BaseClass {

    @Test
    public void handlingFrame(){
        driver.get("https://jqueryui.com/droppable/");

        List<WebElement> allFrame = driver.findElements(By.tagName("iframe"));
        System.out.println("No of frames : "+allFrame.size());

        driver.switchTo().frame(driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/iframe[1]")));
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement,dropElement).build().perform();
    }
}
