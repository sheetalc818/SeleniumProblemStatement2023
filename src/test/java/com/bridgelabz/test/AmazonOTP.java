package com.bridgelabz.test;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AmazonOTP {
    public static final String Account_SID ="AC109c9f5c8031ad793e76abf587604276";
    public static final String Auth_Token ="858789d1ce6816d664f3912316f03ed9";

    public static void main(String[] args) throws InterruptedException
    {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#nav-link-accountList")).click();
        driver.findElement(By.linkText("Start here.")).click();

        driver.findElement(By.id("ap_customer_name")).sendKeys("Testing");
        driver.findElement(By.id("auth-country-picker-container")).click();

        driver.findElement(By.xpath("//ul[@role='application']//li/a[contains(text(),'United States +1')]")).click();
        driver.findElement(By.id("ap_phone_number")).sendKeys("5076657616");
        Thread.sleep(1000);
        driver.findElement(By.id("ap_password")).sendKeys("Premanshu8");
        Thread.sleep(1000);
        driver.findElement(By.id("continue")).click();

        Reporter.log("===Twilio Init===",true);
        Twilio.init(Account_SID,Auth_Token);
        Thread.sleep(500);
        String smsBody = getMessage();
        System.out.println(smsBody);

        //Capturing the OTP from the SMSBody
        String otpNumber = smsBody.replaceAll("[^-?0-9]+", " ");
        System.out.println(otpNumber);

        driver.findElement(By.id("auth-pv-enter-code")).sendKeys(otpNumber);
        driver.findElement(By.id("auth-verify-button")).click();
        Reporter.log("===Account Successfully Created===",true);
        driver.close();
    }

    //get the OTP from Twilio API'S
    public static String getMessage()
    {
        return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                .filter(m -> m.getTo().equals("+15076657616")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    private static Stream<Message> getMessages()
    {
        ResourceSet<Message> message = Message.reader(Account_SID).read();
        return StreamSupport.stream(message.spliterator(), false);
    }
}
