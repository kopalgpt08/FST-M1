import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {
    // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();

    // Open the page
        driver.get("https://www.training-support.net/selenium/input-events");
    // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());
        // Create the Actions object
        Actions builder = new Actions(driver);
        // Left click and print the value of the side in the front.
        builder.click().pause(1000).build().perform();
        // Print the front side text
        String frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Double click to show a random side and print the number.
        builder.doubleClick().pause(1000).build().perform();
        // Print the front side text
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Right click and print the value shown on the front of the cube.
        builder.contextClick().pause(1000).build().perform();
        // Print the front side text
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);
    }

}
