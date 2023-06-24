# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/selenium/dynamic-controls")
    # Initialize wait object
    wait = WebDriverWait(driver, 10)
    # Print the title of the page
    print("Page title is: ", driver.title)
    # Find the checkbox div
    checkbox = driver.find_element(By.ID, "dynamicCheckbox")
    # Find the checkbox toggle button
    checkbox_toggle = driver.find_element(By.ID, "toggleCheckbox")
    # Verify if the checkbox is displayed or not
    print("Checkbox is visible: ", checkbox.is_displayed())

    # Click the checkbox_toggle button to hide checkbox
    checkbox_toggle.click()
    # Wait till the checkbox diappears
    wait.until(EC.invisibility_of_element(checkbox))
    # Verify again if the checkbox is displayed or not
    print("Checkbox is visible: ", checkbox.is_displayed())
    # Close the browser
    driver.quit()
