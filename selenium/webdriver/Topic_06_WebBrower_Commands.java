package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrower_Commands {
    // các cau lenh de thao tac vs Brower:  driver.
    WebDriver driver;
    //các  cau  lenh thao tac vs element:   element.
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver(); //**
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //**
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_() throws MalformedURLException {
        // mở ra 1 url bat ki
        driver.get("https://www.facebook.com/"); //**
        //  nhiều hơn 1 thì nó sẽ đóng cái nó đang active
        driver.close(); //*

        // Đóng browser
        driver.quit(); //**
        // trả ve 1 element neu  tim thấy nhieu hon 1  thì cũng chi lay 1 ( cai dau tien )
        WebElement emailAddressTextBox = driver.findElement(By.id("email")); //**

        // ko dc tìm thấy -  ko bi fail - tra ve 1 list rong
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']")); //**
        // tai sao can lay du lieu ra de lam gi
        // dung de lay ra url cua man hinh/ page hien tai dang dung
        // Home Page
        driver.getCurrentUrl(); //*
        // Neu chi dung 1 lan thi ko khai bao bien
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        // verify 1 cach tuong doi
        driver.getPageSource();
        Assert.assertTrue(driver.getPageSource().contains("The Apple Google Play"));

        // lấy ra tittle hien tai
        driver.getTitle();

        // lay ra id cua cua  so/  tab hien tai
        driver.getWindowHandle(); //*
        driver.getWindowHandles(); //*

        // cookies - famework
        driver.manage().getCookies(); //*

        // Get ra nhung log o devtool - famework
        driver.manage().logs().get(LogType.DRIVER); //*

        //apply cho viec tim element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //**

        // chờ cho page load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // set trc khi dung voi thu vien javacripExecutor
        // Inject  1 duong doan code Js vào browser/element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        // selenium 4 mới có
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getPageLoadTimeout();
        driver.manage().timeouts().getScriptTimeout();

        // chay full man hinh
        driver.manage().window().fullscreen();
        driver.manage().window().maximize(); //**
        driver.manage().window().minimize();

        // test giaao dien
        // test responsive (Resolution)
        driver.manage().window().setSize(new Dimension(1366,768));
        driver.manage().window().getSize();

        // set vi tri browser  so vs do phan giai man hinh
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();

        // dieu huong trang
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // thao tac vs history cua  web page (back / forward )
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));
        //driver.get("https://www.facebook.com/");

        //  Alert / Window (tab) / Frame (iFrame) //*
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("test");

        // Lấy ra ID cua cua so/ tab hien tai   //*
        // Handle window/tab
        String homepageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homepageWindowID);

        //Switch/ handle frame (iframe) //*
        //Index/ ID (name)/ Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("23123121321");
        driver.switchTo().frame(driver.findElement(By.id("")));

        //Switch ve html chua frame trc do
        driver.switchTo().defaultContent();

        //Từ frame trong di ra frame ngoài chứa nó
        driver.switchTo().parentFrame();









    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
