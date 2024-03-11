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

public class MouseAction {

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
        driver.get("https://www.spicejet.com/");
    }

    @Test
    public void hover(){
        //if we are using mouse always remember, there will be action and move to element
        Actions actions=new Actions(driver);
        WebElement addon= driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"));
        actions.moveToElement(addon).perform();
        WebElement click_spicemax= driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar'][normalize-space()='SpiceMax']"));
        actions.moveToElement(click_spicemax).click().perform();
    }

    @Test
    public void doubleclick(){
        Actions actions=new Actions(driver);
        WebElement todoubleclick= driver.findElement(By.xpath("//div[@class='css-76zvg2 r-qsz3a2 r-2t9rge r-adyw6z r-1kfrs79']"));
        actions.moveToElement(todoubleclick).doubleClick().perform();
    }

    @Test
    public void rightclick(){
        Actions actions=new Actions(driver);
        WebElement rclick= driver.findElement(By.xpath("//div[contains(text(),'Hotels')]"));
        actions.contextClick(rclick).perform();

    }

}
