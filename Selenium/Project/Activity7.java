/*Reading additional information
        Goal: Reading a popup that contains additional information about the account/lead.*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
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

    @Test
    public void readingAdditionalInfo() throws InterruptedException {
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

        //Find the salesMenuItem
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement salesMenuItem=driver.findElement(By.xpath("//a[@id='grouptab_0']"));
        // object of Actions with method moveToElement
        Actions a = new Actions(driver);
        a.moveToElement(salesMenuItem).perform();

        //identify sub-menu element Leads
        WebElement leadsSubMenu=driver.
        findElement(By.xpath("//*[text()='Leads']"));
        //move to element and click
        a.moveToElement(leadsSubMenu).click().perform();
        By leadsHeaderPresent=By.xpath("//h2[@class='module-title-text']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(leadsHeaderPresent));

        //Click on Additional information icon at the end of the row of the lead information.
        WebElement additionalDetails=driver.findElement(By.xpath("//tbody/tr[1]/td[10]"));
        additionalDetails.click();

        //Wait till the pop load completely
        By popup=By.xpath("//span[@id='ui-id-6']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(popup));

        //Read the popup and print the phone number displayed in it.
        WebElement phone=driver.findElement(By.xpath("//span[@class='phone']"));
        System.out.println("Phone number is:"+phone.getText());
    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
