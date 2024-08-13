package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Topic_14_Hover {
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
    public void TC_01_Hover_tooltip() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        driver.findElement(By.xpath("//input[@id='age']"));
        action.moveToElement(driver.findElement(By.xpath("//input[@id='age']"))).perform();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content' and text()='We ask for your age only for statistical purposes.']")).getText(),"We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Hover_fahasa() throws InterruptedException {
        driver.get("https://www.fahasa.com/");
        action.moveToElement(driver.findElement(By.xpath("//div[@class='fhs_center_right fhs_mouse_point fhs_dropdown_hover fhs_dropdown_click']//span[@class='icon_menu']"))).perform();
        action.moveToElement(driver.findElement(By.xpath("//a[@title='Đồ Chơi']"))).perform();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Ô Tô']")).getText(),"Ô Tô");


    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
