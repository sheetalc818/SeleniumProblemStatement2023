package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class FindFrameUsingJSExecutor extends BaseClass {
    @Test
    public void frameFinding(){
        driver.get("https://www.guru99.com/handling-iframes-selenium.html");
        JavascriptExecutor j = (JavascriptExecutor) driver;
        int i = Integer.parseInt(j.executeScript("return window.length").toString());
        System.out.println("Int : "+i);
    }
}
