package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FileUploadSendKeys extends BaseClass {
    @Test
    public void sendKeys(){
        driver.get("https://demo.guru99.com/test/upload/");
        driver.findElement(By.name("uploadfile_0")).sendKeys("C:\\Users\\dell\\Downloads\\5-Secrets-from-BridgeLabz (1).pdf");
    }
}
