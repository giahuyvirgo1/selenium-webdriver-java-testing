package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_10_Custom_DropDown {
    WebDriver driver;

    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Jquery() {
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInDropDown("//span[@id='speed-button']","//ul[@id='speed-menu']//div","Slower");
        sleepInSeconds(3);

        selectItemInDropDown("//span[@id='files-button']","//ul[@id='files-menu']//div","ui.jQuery.js");
        sleepInSeconds(3);

//        selectItemInDropDown("span#number-button","ul#number-menu div","3");
//        sleepInSeconds(3);

        selectItemInDropDown("//span[@id='number-button']","//ul[@id='number-menu']//div","3");
        sleepInSeconds(3);

        selectItemInDropDown("//span[@id='salutation-button']","//ul[@id='salutation-menu']//div","Mrs.");
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Slower']")).getText(),"Slower");
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='ui.jQuery.js']")).getText(),"ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='3']")).getText(),"3");
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Mrs.']")).getText(),"Mrs.");



    }

    @Test
    public void TC_02_Logo() {


    }

    @Test
    public void TC_03_Form() {

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
    public void selectItemInDropDown(String parentxPath,String childItemXPath, String itemTextExpected){
        driver.findElement(By.xpath(parentxPath)).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemXPath)));
        List<WebElement> allItems = driver.findElements(By.xpath(childItemXPath));
        for (WebElement item : allItems){
            if (item.getText().equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }
}