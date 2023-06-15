import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Activity1 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://training-support.net");

        // Get the title of the page and print it to the console
        System.out.println("Home page title: " +driver.getTitle());

        //Find the "About Us" button on the page using it's id. and click on it
        driver.findElement(By.id("about-link")).click();
        //Get the title of the new page and print it to the console.
        System.out.println("Title of the new page is:"+driver.getTitle());

        // Close the browser
        driver.quit();
    }

}
