package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_17_Popup {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Popup() {
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.xpath("//span[@class='MuiTouchRipple-root css-w0pj6f' and @style='']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiPaper-elevation ')]")).isDisplayed());
        driver.findElement(By.xpath("//input[@placeholder='Tài khoản đăng nhập']")).sendKeys("automationfc");
        driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']")).sendKeys("automationfc");
        driver.findElement(By.xpath("//button[@type='submit' and @style]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).isDisplayed());
        driver.findElement(By.xpath("//button[contains(@class,'close-btn css-100vahc')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiPaper-elevation ')]")).isDisplayed());


    }
    @Test
    public void TC_02_Popup() {

    }


        @AfterClass
    public void afterClass() {
        driver.quit();
    }
    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
