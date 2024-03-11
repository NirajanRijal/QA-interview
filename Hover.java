package org.interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Hover {

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
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    }

    @Test
    public void hoverandadd(){
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("nirajanrijal8@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test@123");
        Actions actions = new Actions(driver);
        WebElement lapandnote= driver.findElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));
        actions.moveToElement(lapandnote).build().perform();
        WebElement alllap= driver.findElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        actions.moveToElement(alllap).click().build().perform();
    }
}

