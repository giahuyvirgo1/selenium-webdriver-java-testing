package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }
    @Test                                   
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName"));
    }

    @Test
    public void TC_02_CLASS() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_NAME() {
        driver.findElement(By.name("DateOfBirthDay"));
    }
    @Test
    public void TC_04_TAGNAME() {
        driver.findElements(By.tagName("input"));

    }
    @Test
    public void TC_05_LINKtext() {
        // độ chính xác cao = tuyet doi
        driver.findElement(By.linkText("Blog"));


    }
    @Test
    public void TC_06_Partial_LINKtext() {
        // tuong doi
        driver.findElement(By.partialLinkText("for vendor"));


    }
    @Test
    public void TC_07_CSS() {
        // css vs id
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        // css vs class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        // css vs name
        driver.findElement(By.cssSelector("input[name='FirstName']"));
        // css vs tagname
        driver.findElement(By.cssSelector("input"));
        // css vs link
        driver.findElement(By.cssSelector("a[href='/blog']"));
        // css vs paraciallink
        driver.findElement(By.cssSelector("a[href*='blog']"));


    }
    @Test
    public void TC_08_XPath() {
        // XPath vs id
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        // XPath vs class
        driver.findElement(By.xpath("//div[@class='page-title']"));
        // XPath vs name
        driver.findElement(By.xpath("//input[@name='FirstName']"));
        // XPath vs tagname
        driver.findElement(By.xpath("//input"));
        // XPath vs link
        driver.findElement(By.xpath("//a[@href='/blog']"));

        // XPath vs paraciallink
        driver.findElement(By.xpath("//a[contains(@href,'blog')]"));


    }
    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
