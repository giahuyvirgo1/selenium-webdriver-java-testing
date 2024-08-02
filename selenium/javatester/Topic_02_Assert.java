package javatester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.channels.SelectableChannel;

public class Topic_02_Assert {
    WebDriver driver;
    @Test
    public void verifyTESTNG(){
        driver = new FirefoxDriver();

        driver.get("https://www.facebook.com/");
        // Trong java co nhieu thu vien de verify du lieu
        // Testing Framework (Unit/ Intergetion/ UI Automation Test)
        // Junit4 / TestNG/ JUnit5/ Hamcrest/ AssertJ ..
        // khi muon dk tra ve la dung
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));
        // Muốn dieu kien tra ve là sai thì dùng AssertFalse
        Assert.assertFalse(driver.getPageSource().contains("Facebook helps you connect and share with the people in your life."));

        // các hàm trả về kiểu dữ liệu là boolean
        // quy tat bắt dau vs tien to isXXX
        // WebElement
        // DUNG voi assertTrue
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();
        // AssertEqual mong doi 1 dk giong thuc te
        // Actual = Expected
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        Assert.assertEquals(driver.findElement(By.id("")).getText(),"Create new account");

        // Unit test
        Object name = null;
        Assert.assertNull(name);

        name = "testing";
        Assert.assertNotNull(name);






    }
}
