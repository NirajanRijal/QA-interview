package org.interview;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SwitchIframe {

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
    public void Ifram() {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");
        //switch to exact frame
        driver.switchTo().frame("iframeResult");
        //click try buttom now, firstly try without using above code to see

        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
    }
}



