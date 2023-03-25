package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class WindowHandling extends BaseClass {

    @Test
    public void getWindowAndHandle(){
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("windowButton")).click();

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window address : "+parentWindow);

        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> iterator = allWindow.iterator();
        while(iterator.hasNext()){
            String childWindow = iterator.next();
            if(!parentWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                String text = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println("Text of child window :"+text);
            }
        }
        driver.switchTo().window(parentWindow);
        driver.findElement(By.id("tabButton")).click();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println("Tab Text is : "+driver.findElement(By.id("sampleHeading")).getText());
    }
}
