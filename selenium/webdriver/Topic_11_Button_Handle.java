package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;


import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_11_Button_Handle {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void TC_01_egov() {
        driver.get("https://egov.danang.gov.vn/reg");
        WebElement registButton = driver.findElement(By.xpath("//input[@class='egov-button']"));
        Assert.assertFalse(registButton.isEnabled());
        driver.findElement(By.xpath("//input[@id='chinhSach']")).click();
        sleepInSeconds(3);
        Assert.assertTrue(registButton.isEnabled());


        String RegistBackGroundRBG = registButton.getCssValue("background-color");
        // chuyen tu RGB qua color
        Color RegistBackGroundColor = Color.fromString(RegistBackGroundRBG);

        // chuyen qua kiểu hexa
        String RegistBackGroundHexa = RegistBackGroundColor.asHex();

        Assert.assertEquals(RegistBackGroundHexa.toLowerCase(),"#ef5a00");

    }
    @Test
    public void TC_02_fahasa(){
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.xpath("//li[@class='popup-login-tab-item popup-login-tab-login']")).click();
        sleepInSeconds(3);
        WebElement LoginButton = driver.findElement(By.xpath("//button[@class='fhs-btn-login']"));
        Assert.assertFalse(LoginButton.isEnabled());
        sleepInSeconds(3);
        System.out.println(LoginButton.getCssValue("background-color"));
        Assert.assertEquals(Color.fromString(LoginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");

        driver.findElement(By.xpath("//input[@id='login_username']")).sendKeys("giahuyvirgo1@gmail.com");
        driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("123456");
        Assert.assertTrue(LoginButton.isEnabled());
        System.out.println(LoginButton.getCssValue("background-color"));
        Assert.assertEquals(Color.fromString(LoginButton.getCssValue("background-color")).asHex().toLowerCase(),"#c92127");




    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
