package org.interview;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class WindowHandelAndPageRefresh {

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
    public void window() {
        //Store the ID of the original window
        driver.get("https://omayo.blogspot.com/");
        String originalWindow = driver.getWindowHandle();
        //Click the link which opens in a new window
        driver.findElement(By.xpath("//a[normalize-space()='Open a popup window']"));
        // store all opened window
        Set<String> allwindow = driver.getWindowHandles();
        //Loop through until we find a new window handle
        for (String windowHandle : allwindow) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }


        }
    }
}




