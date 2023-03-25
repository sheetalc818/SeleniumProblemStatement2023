package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class AutoSuggestionList extends BaseClass {
    @Test
    public void Auto_Sugg_ListBox() {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium");
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
        int count = list.size();
        System.out.println("List option count :" + count);
        String expectedValue = "selenium download";
        for (WebElement option : list) {
            String text = option.getText();
            System.out.println(" " + text);
            if (text.contains(expectedValue)) {
                option.click();
                break;
            }
        }
    }
}
