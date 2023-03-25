package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

public class MultiSelectDemo extends BaseClass {
    @Test
    public void multiSelect_YesOrNo() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        Select dropDown = new Select(driver.findElement(By.xpath("//*[@id='cars']")));

        if(dropDown.isMultiple()){
            dropDown.selectByIndex(1);
            dropDown.selectByValue("audi");
            dropDown.selectByVisibleText("Volvo");
        }
        Thread.sleep(2000);
//        dropDown.deselectAll();
//        dropDown.deselectByIndex(1);
//        dropDown.deselectByValue("6");
//        dropDown.deselectByVisibleText("Volvo");
        System.out.println("first selection:" + dropDown.getFirstSelectedOption().getText());

        List<WebElement> selectedOptions = dropDown.getAllSelectedOptions();
        for(WebElement selectedOption: selectedOptions)
            System.out.println(selectedOption.getText());
    }
}
