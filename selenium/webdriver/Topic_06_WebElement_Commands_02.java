package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebElement_Commands_02 {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_isDisplayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.xpath("//input[@id='mail']")).isDisplayed()){
            driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("Automation Testing");
            System.out.println("Email text box is Displayed");
        }else {
            System.out.println("Email text box is not Displayed");
        }


        if (driver.findElement(By.xpath("//input[@id='under_18']")).isDisplayed()){
            driver.findElement(By.xpath("//input[@id='under_18']")).click();
            System.out.println("Under 18 Radio is Displayed");
        }else {
            System.out.println("Under 18 Radio is not Displayed");
        }


        if (driver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed()){
            driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation Testing");
            System.out.println("TextAreaEdu is Displayed");
        }else {
            System.out.println("TextAreaEdu is not Displayed");
        }


        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            driver.findElement(By.xpath("//h5[text()='Name: User5']"));
            System.out.println("Text NameUser5 is Displayed");
        }else {
            System.out.println("Text NameUser5 is  Not Displayed");
        }



    }
    @Test
    public void TC_02_isEnable() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.xpath("//input[@id='mail']")).isEnabled()){
            driver.findElement(By.xpath("//input[@id='mail']"));
            System.out.println("Email text box is Enabled");
        }else {
            System.out.println("Email text box is not Enabled");
        }

        if (driver.findElement(By.xpath("//input[@id='under_18']")).isEnabled()){
            driver.findElement(By.xpath("//input[@id='under_18']"));
            System.out.println("Under 18 Radio is Enabled");
        }else {
            System.out.println("Under 18 Radio is not Enabled");
        }

        if (driver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled()){
            driver.findElement(By.xpath("//textarea[@id='edu']"));
            System.out.println("TextAreaEdu is Enabled");
        }else {
            System.out.println("TextAreaEdu is not Enabled");
        }

        if (driver.findElement(By.xpath("//input[@id='disable_password']")).isDisplayed()){
            driver.findElement(By.xpath("//input[@id='disable_password']"));
            System.out.println("Text password is disable");
        }else {
            System.out.println("Text password is enable");
        }

    }
    @Test
    public void TC_03_isSelected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//input[@id='under_18']")).click();
        driver.findElement(By.xpath("//input[@id='java']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='java']")).isSelected());

        driver.findElement(By.xpath("//input[@id='java']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='java']")).isSelected());



    }
    @Test
    public void TC_04_RegisterFuntionAtMailChimp() {
        driver.get("https://login.mailchimp.com/signup/");
        sleepInSeconds(5);

        //driver.findElement(By.cssSelector("input#email")).sendKeys("giahuyvirgo1@gmail.com");
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("12345");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());


        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        sleepInSeconds(5);

        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("huy");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());


        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        sleepInSeconds(5);

        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("Lehoanggiahuy1609@");
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

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
