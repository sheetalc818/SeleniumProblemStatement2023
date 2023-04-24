package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotFileUpload extends BaseClass {
    @Test
    public void toUploadFile() throws AWTException{
        Robot robot = new Robot();
        driver.get("https://www.foundit.in/seeker/registration");
        StringSelection selection = new StringSelection("C:\\Users\\Admin\\Downloads\\sample.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        WebElement chooseCsv = driver.findElement(By.xpath("//*[@id=\"registerThemeDefault\"]/div/div[4]/div/div/div/form/div[1]/div[2]/div/div/div[1]/div/label/span"));
        chooseCsv.click();

        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.delay(1000);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.delay(3000);

        WebElement name = driver.findElement(By.name("fullname"));
        name.sendKeys("Sheetal");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("abcd@gmail.com");

        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("qwerty231");
    }
}
