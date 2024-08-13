package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_09_DefaultDropDown {
    WebDriver driver;
    String FirstName =  "Automation"  , LastName = "FC", Email= getEmailAddress();
    String Company = "HHT" , Password = "123456789" ;

    String day = "16", month  ="December" , year = "1999";


    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Register() {
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//div[@class=\"header-links\"]//a[@class='ico-register']")).click();
        sleepInSeconds(3);
        // regist
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(FirstName);
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(LastName);

        Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
        day.selectByVisibleText(this.day);
        sleepInSeconds(3);

        Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        month.selectByVisibleText(this.month);
        sleepInSeconds(3);

        Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
        year.selectByVisibleText(this.year);
        sleepInSeconds(3);



        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Email);
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(Company);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(Password);

        driver.findElement(By.xpath("//div[@class='buttons']")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");

        //driver.findElement(By.xpath("//div[@class='buttons']")).click();



    }
    @Test
    public void TC_02_Login(){
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
//        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(Email);
//        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
//        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
//        sleepInSeconds(3);
//        driver.findElement(By.xpath("//a[@class='ico-account']")).click();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"),FirstName);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='LastName']")).getAttribute("value"),LastName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),day );
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month );
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year );

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Email']")).getAttribute("value"),Email);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Company']")).getAttribute("value"),Company);






    }


    @AfterClass
    public void afterClass() {
      // driver.quit();
    }
    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
    public String getEmailAddress(){
        Random rand = new Random();
        return "automation" + rand.nextInt(9999) + "@gmail.net";
    }
}
