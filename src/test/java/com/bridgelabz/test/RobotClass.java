package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotClass extends BaseClass {
    @Test
    public void uploadFile() throws AWTException, InterruptedException {
        driver.get("https://www.foundit.in/seeker/registration");
        StringSelection selection = new StringSelection("C:\\Users\\Admin\\Downloads\\Sample.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        WebElement clickUploadBtn = driver.findElement(By.xpath("//body[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[4]/div[1]/div[1]/img[1]"));
        clickUploadBtn.click();
        Thread.sleep(500);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.delay(100);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(100);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(1000);
    }
}
