/*Menu checking
        Goal: Make sure that the “Activities” menu item exists and is clickable*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {
    // Declare the WebDriver object
    private WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setupMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser and navigate to url
        driver.get("https://alchemy.hguy.co/crm");
    }

    @Test()
    public void menuChecking() {
        //Login the application

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

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Locate the "Activities" navigation menu
        By activityMenuIsPresent = By.xpath("//a[@id='grouptab_3']");

        //Ensure that the “Activities” menu item exists
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(activityMenuIsPresent));
            System.out.println("“Activities” menu item exists");
        } catch (TimeoutException e) {
            System.out.println("“Activities” menu item does not exist");
        }
    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
           driver.close();
    }
}
