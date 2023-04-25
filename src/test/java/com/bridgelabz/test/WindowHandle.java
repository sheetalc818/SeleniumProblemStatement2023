package com.bridgelabz.test;

import com.bridgelabz.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle extends BaseClass {
        @Test
        public void revisionTest() {
            driver.get("https://www.linkedin.com/signup/cold-join?session_redirect=%2Fpulse%2Fhow-write-letter-recommendation-get-hired-by-linkedin-news&trk=article-ssr-frontend-pulse_nav-header-join");
            System.out.println("Source Data : " + driver.getPageSource());

            String parentWindow = driver.getWindowHandle();
            System.out.println("Parent Address : "+parentWindow);

            driver.findElement(By.linkText("Get help")).click();

            Set<String> allWindows = driver.getWindowHandles();
            Iterator<String> iterator = allWindows.iterator();
            while (iterator.hasNext()) {
                String childWindow = iterator.next();
                System.out.println("Child Address : " + childWindow);
                if (!parentWindow.equalsIgnoreCase(childWindow)) {
                    driver.switchTo().window(childWindow);
                    System.out.println("Success new window");
                    System.out.println(driver.switchTo().window(childWindow).getTitle());
                    driver.findElement(By.id("desktop-nav-search-query")).sendKeys("Testing");
                }
            }
            driver.switchTo().window(parentWindow);
            System.out.println("Success!!");
        }

//    @AfterTest
//    public void tearDown(){
//        closeB();
//    }
}
