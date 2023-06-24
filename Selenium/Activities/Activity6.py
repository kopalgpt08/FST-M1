# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains

# import KEYS
from selenium.webdriver.common.keys import Keys

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("https://www.training-support.net/selenium/input-events")
    # Print the title of the page
    print("Page title is: ", driver.title)
    # Set up the actions object
    actions = webdriver.ActionChains(driver)
    # Press the key
    actions.send_keys("K")
    # Press CTRL+A and CTRL+C
    actions.key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(
        Keys.CONTROL
    ).perform()

    # Close the browser
    driver.quit()
