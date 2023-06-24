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
    # Find the input text box
    textbox = driver.find_element(By.ID, "input-text")
    # Find the toggle input button
    textbox_toggle = driver.find_element(By.ID, "toggleInput")
    # Verify if the text box is enabled or not
    print("Text box is enabled: ", textbox.is_enabled())
    # Click the text box toggle button
    textbox_toggle.click()
    # Verify if the text box is enabled or not
    print("Text box is enabled: ", textbox.is_enabled())
    textbox.send_keys("Kopal")
    # Close the browser
    driver.quit()
