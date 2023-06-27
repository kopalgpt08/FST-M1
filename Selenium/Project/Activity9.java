/*Traversing tables 2
        Goal: Open the leads page and print the usernames and full names from the table*/
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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
import java.util.List;

public class Activity9 {
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
    public void traversingTables2() throws InterruptedException {
        //Login the application

        // Find the username field and enter the username
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        // Find the password field and enter the password
        driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
        // Find the login button and click it
        driver.findElement(By.xpath("//input[@name='Login']")).click();
        String expectedTitle = "SuiteCRM";
        System.out.println("Title of the WebPage is:" + driver.getTitle());
        if (driver.getTitle() != null && driver.getTitle().contains(expectedTitle)) {
            System.out.println("Home page is opened");
        } else {
            System.out.println("Home page could not open.");
        }

        //Find the salesMenuItem
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement salesMenuItem = driver.findElement(By.xpath("//a[@id='grouptab_0']"));
        // object of Actions with method moveToElement
        Actions a = new Actions(driver);
        a.moveToElement(salesMenuItem).perform();

        //identify sub-menu element Accounts
        WebElement leadsSubMenu = driver.
                findElement(By.xpath("//*[text()='Leads']"));
        //move to element and click
        a.moveToElement(leadsSubMenu).click().perform();
        By leadsHeaderPresent = By.xpath("//h2[@class='module-title-text']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(leadsHeaderPresent));


        // Finding number of rows in a web table.
        List allRows = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
        System.out.println("Total data rows found in table:" + (allRows.size()));

        // print the first 10 values in the Name column and the User column of the table to the console
        System.out.println("print the first 10 values in the Name column and the User column of the table to the console:");
        System.out.println("Name Column" +" "+"|"+" "+"User Column");
        for (int i = 1; i <= 10; i++) {
            //Find the name column values and print it
            WebElement nameColumn = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[" + i + "]/td[3]"));
            //Find the user column values and print it
            WebElement userColumn = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[" + i + "]/td[8]"));
            System.out.print(nameColumn.getText() + " |" +userColumn.getText());
            System.out.println();
            }
        }


    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
