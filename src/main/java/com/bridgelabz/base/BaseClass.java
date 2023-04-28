package com.bridgelabz.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass extends ReadPropertiesFile{
    public static WebDriver driver = null;
    public static ExtentTest test;
    public static ExtentReports report;
    public static Logger log = Logger.getLogger(BaseClass.class.getName());

    @BeforeMethod
    public void setUp(){
        PropertyConfigurator.configure("C:\\Users\\Admin\\Documents\\QADevPrograms\\SeleniumProblemStatement2023\\log4j.properties");
        BasicConfigurator.configure();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        log.info("Browser Initialised");
        //driver.get("https://demoqa.com/browser-windows");
        //driver.navigate().to("https://mvnrepository.com/artifact/org.testng/testng/7.7.0");
        //driver.get("https://www.facebook.com/");
        //driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        log.error("Maximize Window");
        report = new ExtentReports("C:\\Users\\Admin\\Documents\\QADevPrograms\\SeleniumProblemStatement2023\\ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
    }

    @AfterMethod
    public void tearDown(){
        log.info("Tear Down of Browser");
        driver.close();
        report.endTest(test);
        report.flush();
    }

    public static void takeScreenshot() throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/main/resources/screenshot1"+ System.currentTimeMillis() +".png");
        FileUtils.copyFile(scrFile,destinationFile);
    }
}
