package org.interview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class DifferentBrowser {
    WebDriver driver=null;
    String browser="edge"; //if we use chrome here, it will open in chrome

    @BeforeTest
    public void beforetest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\CucumberPractice\\QAinterview\\src\\test\\resources\\driver\\chromedriver.exe");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions ops = new ChromeOptions();
            driver = new ChromeDriver(ops);
        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions ops = new EdgeOptions();
            driver = new EdgeDriver(ops);

            }
            //ops.addArguments("--remote-allow-origins=*");
            //ops.addArguments("--start-maximized");
            //ops.addArguments("--incognito");
            // this is code for headless
            //ops.addArguments("--headless");
            //ops.setExperimentalOption("useAutomationExtension", false);
            //ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            //implicit wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.saucedemo.com/");
        }

        @Test
        public void enabled () {
            System.out.println(driver.findElement(By.xpath("//input[@id='login-button']")).isEnabled());
        }

    }



