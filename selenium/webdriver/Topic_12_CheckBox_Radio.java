package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_12_CheckBox_Radio {
    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Default_CheckBox() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        By CheckBoxRear = By.xpath("//input[@id='eq1']");
        By CheckBoxDual = By.xpath("//input[@id='eq5']" );
        driver.findElement(CheckBoxDual).click();
        if (!driver.findElement(CheckBoxRear).isSelected()){
            driver.findElement(CheckBoxRear).click();
            sleepInSeconds(3);
        }

        Assert.assertTrue(driver.findElement(CheckBoxDual).isSelected());
        sleepInSeconds(3);
        driver.findElement(CheckBoxDual).click();
        Assert.assertFalse(driver.findElement(CheckBoxDual).isSelected());
        Assert.assertTrue(driver.findElement(CheckBoxRear).isSelected());


    }
    @Test
    public void TC_02_Default_Radio() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By RadioTwoPetrol = By.xpath("//input[@id='engine3']");
        driver.findElement(RadioTwoPetrol).click();
        sleepInSeconds(3);
        Assert.assertTrue(driver.findElement(RadioTwoPetrol).isSelected());


    }
    @Test
    public void TC_03_SelectAll_SelectOneToAll() {
        driver.get("https://automationfc.github.io/multiple-fields/");
        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//div[@class='form-single-column']//input[@type='checkbox']"));
        for (WebElement checkbox : allCheckBoxes){
            if (!checkbox.isSelected()){
                checkbox.click();
            }
        }
        for (WebElement checkbox : allCheckBoxes){
            Assert.assertTrue(checkbox.isSelected());
        }
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        allCheckBoxes = driver.findElements(By.xpath("//div[@class='form-single-column']//input[@type='checkbox']"));

        for (WebElement checkbox : allCheckBoxes){
            if (checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()){
                checkbox.click();
                sleepInSeconds(1);
            }
        }

        for (WebElement checkbox : allCheckBoxes){
            if (checkbox.getAttribute("value").equals("Heart Attack")){
                Assert.assertTrue(checkbox.isSelected());
            }else
                Assert.assertFalse(checkbox.isSelected());

        }



    }
    @Test
    public void TC_04_DocGoogle() {
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By RadioCanTho = By.xpath("//div[@aria-label='Cần Thơ']");
        Assert.assertEquals(driver.findElement(RadioCanTho).getAttribute("aria-checked"),"false");
        driver.findElement(RadioCanTho).click();
        sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(RadioCanTho).getAttribute("aria-checked"),"true");
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
