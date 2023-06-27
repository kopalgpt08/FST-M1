/*
Traversing tables
        Goal: Open the accounts page and print the contents of the table.
*/

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

public class Activity8 {
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
    public void traversingTables() throws InterruptedException {
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

        //identify sub-menu element Accounts
        WebElement accountsSubMenu=driver.
                findElement(By.xpath("//*[text()='Accounts']"));
        //move to element and click
        a.moveToElement(accountsSubMenu).click().perform();
        By accountsHeaderPresent=By.xpath("//h2[@class='module-title-text']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountsHeaderPresent));


        // Finding number of rows in a web table.
        List allRows= driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
        System.out.println("Total data rows found in table:"+ (allRows.size()));

        // print the names of the first 5 odd-numbered row of the table to the console
        int rowIndex=0;
        System.out.println(" print the names of the first 5 odd-numbered rows\n" +
                "of the table to the console: ");
        for(int i=1;i<=allRows.size();i=i+2)
        {
            //Only first 5 rows are needed
            if(rowIndex<5) {
                //Find the number of columns in each row and print it
                List<WebElement> allColumnsInRow = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr[" + i + "]/td"));
                for (int j = 0; j < allColumnsInRow.size(); j++) {
                    System.out.print(allColumnsInRow.get(j).getText() + " ");
                }
                System.out.println();
            }
            rowIndex++;
        }

    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
