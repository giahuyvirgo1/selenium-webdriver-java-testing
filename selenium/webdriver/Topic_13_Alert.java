package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_13_Alert {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        sleepInSeconds(3);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        sleepInSeconds(3);
        alert.accept();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You clicked an alert successfully");

    }
    @Test
    public void TC_02_Comfirm_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        sleepInSeconds(3);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        sleepInSeconds(3);
        alert.dismiss();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You clicked: Cancel");

    }
    @Test
    public void TC_03_Prompt_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        sleepInSeconds(3);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        sleepInSeconds(3);
        String text = "deptrai" ;
        alert.sendKeys(text);
        sleepInSeconds(3);
        alert.accept();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),"You entered: "+text);






    }
    @Test
    public void TC_04_Authentication_Alert() {
        String username = "admin";
        String password = "admin";
        driver.get("http://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
        sleepInSeconds(3);
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
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
