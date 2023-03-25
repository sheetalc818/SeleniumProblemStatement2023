package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class ExtentDemo extends BaseClass {

    @Test
    public void extentReportsDemo()
    {
        driver.get("https://www.google.co.in");
        if(driver.getTitle().equals("Google"))
        {
            test.log(LogStatus.PASS, "Navigated to the specified URL");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed");
        }
    }
}
