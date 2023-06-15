# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("https://training-support.net/selenium/login-form")

    #  Get the title of the page and print it to the console
    print("Home page title:" + driver.title)
    # Find the username field using any locator and enter "admin" into it.
    driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")

    # Find the password field using any locator and enter "password" into it.
    driver.find_element(By.XPATH, "//input[@id='password']").send_keys("password")
    # Find the login button and click it
    driver.find_element(By.XPATH, "//button[text()='Log in']").click()

    # Print the confirmation message
    message = driver.find_element(By.XPATH, "//div[@id='action-confirmation']")
    print("Login message: ", message.text)
    # Close the browser
    driver.quit()
