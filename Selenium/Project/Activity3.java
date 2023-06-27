/*Get the copyright text
        Goal: Print the first copyright text in the footer to the console*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
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
    public void getCopyrightText() {
        //Get the xpath of  footer
        WebElement footer =driver.findElement(By.xpath("//div[@class='p_login_bottom']"));

        //getText() to Get the first copyright text in the footer by using tagname a
        String firstCopyrightText=footer.findElements(By.tagName("a")).get(0).getText();
        System.out.println("The first copyright text in the footer is:"+firstCopyrightText);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
