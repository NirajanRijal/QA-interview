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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class UploadAndDownload {

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
        // To download
        String downloadPath = System.getProperty("user.dir");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        ops.setExperimentalOption("prefs",chromePrefs);

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //@Test
    public void upload(){
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.xpath("//input[@id='uploadfile']")).sendKeys("C:\\Users\\USER\\Desktop\\Nikon.jpg");
    }

    //@Test
    public void uploadworkspace(){
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.xpath("//input[@id='uploadfile']")).sendKeys("C:\\Users\\USER\\Desktop\\CucumberPractice\\QAinterview\\src\\test\\resources\\file\\Nikon.jpg");

    }

    @Test
    public void download(){
        driver.get("http://omayo.blogspot.com/p/page7.html");
        driver.findElement(By.linkText("ZIP file")).click();

    }

}


