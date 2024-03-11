package org.interview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
public class Verification {
    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\CucumberPractice\\QAinterview\\src\\test\\resources\\driver\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        driver = new ChromeDriver(ops);
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.addArguments("--incognito");
        // this is code for headless
        //ops.addArguments("--headless");
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://www.saucedemo.com/");
    }

    //@Test
    public void displayed(){
        System.out.println(driver.findElement(By.xpath("//input[@id='login-button']")).isDisplayed());
            }
    //similarly, check login bottom is enabled or disabled, if we can click it, it's in enable stage

    //@Test
    public void enabled(){
        System.out.println(driver.findElement(By.xpath("//input[@id='login-button']")).isEnabled());
    }

    @Test
    public void checkbox(){
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement((By.xpath("//span[normalize-space()='My Account']"))).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        System.out.println(driver.findElement((By.xpath("//input[@name='agree']"))).isSelected());
    }

    //@Test
    public void size(){
        driver.findElement(By.xpath("//input[@id='login-button']")).getSize();
    }

    //@Test
    public void titlecheck(){
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
    }

}


