import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the page
        driver.get("https://training-support.net/selenium/dynamic-controls");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());
        // Find the toggle button and click it to hide the checkbox
        WebElement checkbox_toggle = driver.findElement(By.id("toggleCheckbox"));
        checkbox_toggle.click();
        WebElement checkbox=driver.findElement(By.id("dynamicCheckbox"));
        // Wait for the checkbox to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("Checkbox displayed:"+checkbox.isDisplayed());
        // Click the button again
        checkbox_toggle.click();
        // Wait for the element to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("Checkbox displayed:"+checkbox.isDisplayed());
        //Click the checkbox
        checkbox.click();
        // Close the browser
       // driver.close();
    }
}
