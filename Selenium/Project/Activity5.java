/*Getting colors
        Goal: Get the color of the navigation menu*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Activity5 {
    // Declare the WebDriver object
    private WebDriver driver;

    @BeforeMethod()
    public void setupMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser and navigate to url
        driver.get("https://alchemy.hguy.co/crm");
    }

    @Test(priority=1)
    public void loggingIntoSite() {
        // Find the username field and enter the username
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        // Find the password field and enter the password
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        // Find the login button and click it
        driver.findElement(By.xpath("//input[@name='Login']")).click();
        String expectedTitle="SuiteCRM";
        System.out.println("Title of the WebPage is:"+driver.getTitle());
        if(driver.getTitle() != null && driver.getTitle().contains(expectedTitle)){
            System.out.println("Home page is opened");
        }
        else{
            System.out.println("Home page could not open.");
        }

    }
    @Test(priority=2)
    public void getNavigationBarColor() {
        loggingIntoSite();
        // Get the color of the navigation menu
        String navBarxpath = driver.findElement(By.xpath("//nav[@role='navigation']")).getCssValue("color");
        System.out.println("The color of the navigation menu is:"+navBarxpath);
    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
