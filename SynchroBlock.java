package org.interview;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class SynchroBlock {

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
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");

    }

    @Test
    public void enterkey() {
        try {
            driver.findElement(By.id("user-name")).sendKeys("problem_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            synchronized (driver) {
                driver.wait(5000);
            }
            driver.findElement(By.id("login-button")).sendKeys(Keys.ENTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


