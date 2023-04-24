package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActionClass extends BaseClass {

    @Test
    public void demoAction() throws InterruptedException {
        driver.get("https://www.facebook.com/");

        WebElement username = driver.findElement(By.id("email"));
        Actions actions = new Actions(driver);

        Action seriesOfActions = actions.moveToElement(username)
                                 .click()
                                 .sendKeys(username, "testingtestdatablz@gmail.com")
                                 .doubleClick(username)
                                 .build();
        seriesOfActions.perform();
    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Actions actions = new Actions(driver);
//        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
//        Thread.sleep(1000);
//        actions.keyUp(Keys.CONTROL).sendKeys(Keys.END).build().perform();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).build().perform();
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        //actions.sendKeys(Keys.PAGE_UP).build().perform();

        WebElement draggableElement = driver.findElement(By.xpath("//body[1]/section[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"));
        actions.clickAndHold(draggableElement).perform();

        WebElement droppableElement = driver.findElement(By.xpath("//body[1]/section[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/ol[1]/li[1]"));
        actions.dragAndDrop(draggableElement,droppableElement).perform();
        Thread.sleep(2000);
        actions.contextClick(draggableElement);
        Thread.sleep(2000);
    }
}
