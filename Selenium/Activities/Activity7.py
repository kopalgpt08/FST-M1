# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains

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

    # Find the football
    ball = driver.find_element(By.ID, "draggable")
    # Find the dropzones1 and dropzone2
    dropzone1 = driver.find_element(By.ID, "droppable")
    dropzone2 = driver.find_element(By.ID, "dropzone2")

    # Perform drag and drop to dropzone 1
    actions.drag_and_drop(ball, dropzone1).perform()
    if dropzone1.text.find("Dropped!"):
        print("Dropzone 1 was activated!")

    # Perform drag and drop to dropzone 2
    actions.drag_and_drop(ball, dropzone2).perform()
    if dropzone2.text.find("Dropped!"):
        print("Dropzone 2 was activated!")
    # Close the browser
    driver.quit()
