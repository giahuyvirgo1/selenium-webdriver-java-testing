package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_15_Action_II {
    WebDriver driver;

    Actions action;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_ClickAndHold_Block() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> AllElementsBlock = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
        Assert.assertEquals(AllElementsBlock.size(),20);
        action.clickAndHold(AllElementsBlock.get(0)).moveToElement(AllElementsBlock.get(3)).release().perform();
        Thread.sleep(3000);
        List<WebElement> AllElementsSelected = driver.findElements(By.xpath("//ol[@id='selectable']//li[contains(@class,'ui-selected')]"));
        Assert.assertEquals(AllElementsSelected.size(),4);

    }
    @Test
    public void TC_02_ClickAndHold_Random() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        List<WebElement> AllElementsBlock = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
        Assert.assertEquals(AllElementsBlock.size(),20);
        action.keyDown(Keys.CONTROL).perform();
        action.click(AllElementsBlock.get(0))
                .click(AllElementsBlock.get(13))
                .click(AllElementsBlock.get(10))
                .click(AllElementsBlock.get(19)).release().perform();
        Thread.sleep(3000);
        List<WebElement> AllElementsSelected = driver.findElements(By.xpath("//ol[@id='selectable']//li[contains(@class,'ui-selected')]"));
        Assert.assertEquals(AllElementsSelected.size(),4);



    }
    @Test
    public void TC_03_Double_CLick()  {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Hello Automation Guys!']")).getText(),"Hello Automation Guys!");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
