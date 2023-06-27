/*Get the url of the header image
        Goal: Print the url of the header image to the console*/
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Activity2 {
    // Declare the WebDriver object
    private WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser and navigate to url
        driver.get("https://alchemy.hguy.co/crm");
    }

    @Test
    public void getUrlOfHeader() {
        //Get the xpath of the header image.
        WebElement srcImage =driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));

        //getAttribute() to get src of image and print the url to the console
        System.out.println("Url of the header image is: "+ srcImage.getAttribute("src"));
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
