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

public class Topic_07_WebElement_Commands {
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
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Element() {
        // HTML Element:  TextBox/ TextArea/ CheckBox/ DropDown/ Link/ Button/...
        // Tìm và trả về 1 element  ( chưa tuong tac )
        driver.findElement(By.id(""));

        // tìm và tương tác lên
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).sendKeys();

        // Tim va luu nó vào 1 biến WebElement ( chưa tuong tac )
        //Khi có dung bien 2  lan tro len
        // tra ve 1 element khop dieu kien
        WebElement fullNameTextbox = driver.findElement(By.id(""));
        // dung de xoa du lieu trong 1 field cho phep nhap ( editable )
        fullNameTextbox.clear(); //*
        // dung de nhap lieu  vao cac field ben tren
        fullNameTextbox.sendKeys("Automation FC"); //**
        // dung de click len element
        driver.findElement(By.id("")).click(); //**
        // tra ve nhieu element khop vs dieu kien
        List<WebElement> testboxes = driver.findElements(By.cssSelector(""));
        //java non Generic
        ArrayList name = new ArrayList<>();
        name.add("Automation FC");
        name.add(15);
        name.add('B');
        name.add(true);
        // Dùng de verify 1 checkbox/ radio/ dropdown (default) đã được chọn hay chưa
        Assert.assertTrue(driver.findElement(By.id("")).isSelected()); //*
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        // Dropdown (default/ custom)
        Select select = new Select(driver.findElement(By.id("")));

        // Dung de verify 1 element bat ki hien thi hay ko
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed()); //**

        // dung de verify 1 element co dc thao tac len hay ko ( ko phải read only )
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled()); //*
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        // HTML Element
        // <input type="text" id="firstname" name="firstname" value=""
        // tittle="First Name" maxlength="255" class="input-text required-entry">
        driver.findElement(By.id("")).getAttribute("title"); //*

        //  tab Accessiblity/ Properties trong element
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("baseURI");

        //Tab Syle trong Element
        // font/size/color/ background/...
        driver.findElement(By.id("")).getCssValue("background-color"); //*

        // vi tri cua element so vs độ phân giải màn hình

        Point nameTextboxLocationn = driver.findElement(By.id("")).getLocation();

        // chiều cao + rộng
        Dimension addressSize = driver.findElement(By.id("")).getSize();

        // location + size
        Rectangle nameTextBoxRect = driver.findElement(By.id("")).getRect();

        // Location
        Point namePoint = nameTextBoxRect.getPoint();

        // Size
        Dimension nameSize = nameTextBoxRect.getDimension();
        nameSize.getHeight();
        nameSize.getWidth();

        // shadow element (javacriptExecutor)
        driver.findElement(By.id("")).getShadowRoot();

        // từ id/ class/ name/ css/ xpath co the truy ra nguoc tagname HTML
        driver.findElement(By.cssSelector("#firstname")).getTagName(); //input
        driver.findElement(By.id("firstname")).getTagName();

        driver.findElement(By.cssSelector("address.copyright")).getText(); //**
        //@ 2015 ...

        // chup hinh bi loi va luu duoi dang nao
        // Byte
        // File (luu thanh 1 hinh co kich thuoc trong o cung:.png .jpg ... )
        // BASE64 (hinh dang text )
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BASE64); //*
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BYTES);

        // Form (element nao la the form hoac nam trong the form )
        // Register / login / search ...
        // hanh vi giong phim enter
        driver.findElement(By.id("")).submit();







        fullNameTextbox.getAttribute("value");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
