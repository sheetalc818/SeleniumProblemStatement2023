package com.bridgelabz.test;

import com.beust.ah.A;
import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass extends BaseClass {

    @Test
    public void actionsClass() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        Actions action = new Actions(driver);
        //action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME);
        //action.keyDown(Keys.CONTROL).sendKeys(Keys.END);

        driver.switchTo().frame(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/iframe[1]")));
        WebElement draggable = driver.findElement(By.id("draggable"));
        action.clickAndHold(draggable).perform();

        WebElement droppable = driver.findElement(By.id("droppable"));
        Thread.sleep(1000);
        action.dragAndDrop(draggable,droppable).perform();
        Thread.sleep(1000);
    }

    @Test
    public void actionsClass_FacebookLoginScreen() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement email = driver.findElement(By.id("email"));
        Action seriesActions = actions.moveToElement(email)
                .click()
                .keyDown(email, Keys.SHIFT)
                .sendKeys(email,"testing")
                .keyUp(email, Keys.SHIFT)
                .doubleClick(email)
                .build();
        seriesActions.perform();

        Thread.sleep(1000);
        WebElement loginBtn = driver.findElement(By.name("login"));
        actions.moveToElement(loginBtn).click().perform();
        Thread.sleep(2000);
    }
}
