package org.interview;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {
    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        String rootpath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\CucumberPractice\\QAinterview\\src\\test\\resources\\driver\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.addArguments("--incognito");
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(ops);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void writingalert() {
        driver.get("https://www.flipkart.com/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("alert('Nirajan Rijal')");
    }

    @Test
    public void scrolling() {
        driver.get("https://www.flipkart.com/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,5000)");


    }

    @After
    public void close(){
        driver.quit();
    }

}