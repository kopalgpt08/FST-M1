# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.select import Select

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/selenium/javascript-alerts")
    # initialize the wait object
    wait = WebDriverWait(driver, 10)
    # Print the title of the page
    print("Page title is: ", driver.title)
    # Find the confirm button and click it
    driver.find_element(By.ID, "confirm").click()
    # Switch focus to the alert
    confirm_alert = driver.switch_to.alert
    # Print the text in the alert
    print(confirm_alert.text)
    # Close the alert with either one of the methods
    # with OK
    confirm_alert.accept()
    # Find the confirm button and click it
    driver.find_element(By.ID, "confirm").click()
    # Switch focus to the alert
    confirm_alert1 = driver.switch_to.alert
    # with Cancel
    confirm_alert1.dismiss()
    # Close the browser
    driver.quit()
