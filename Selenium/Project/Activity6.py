#Menu checking
#Goal: Make sure that the “Activities” menu item exists and is clickable


# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service = service) as driver:
  
    # Open the browser to the URL
    driver.get("https://alchemy.hguy.co/crm")

    # Read the title of the website and verify the text
    print("Home page title:"+driver.title)
  
    # Find the username field and enter the username
    driver.find_element(By.XPATH,"//input[@id='user_name']").send_keys("admin")
    # Find the password field and enter the password
    driver.find_element(By.XPATH,"//input[@id='username_password']").send_keys("pa$$w0rd")
    # Find the login button and click it
    driver.find_element(By.XPATH,"//input[@name='Login']").click()
  
    wait = WebDriverWait(driver, 10)  # Wait for a maximum of 10 seconds

    # Locate the "Activities" navigation menu
    activity_menu_is_present = By.XPATH, "//a[@id='grouptab_3']"

    # Ensure that the "Activities" menu item exists
    try:
        wait.until(EC.presence_of_element_located(activity_menu_is_present))
        print("“Activities” menu item exists")
    except TimeoutException:
        print("“Activities” menu item does not exist")

    # Close the browser
    driver.close()