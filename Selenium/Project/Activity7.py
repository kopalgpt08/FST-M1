#Reading additional information
#Goal: Reading a popup that contains additional information about the account/lead


# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException
from selenium.webdriver import ActionChains

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
  
    # Wait for a maximum of 10 seconds
    wait = WebDriverWait(driver, 10)  

    # Find the salesMenuItem
    sales_menu_item = driver.find_element(By.XPATH, "//a[@id='grouptab_0']")

    # Create an instance of Actions
    actions = ActionChains(driver)
    actions.move_to_element(sales_menu_item).perform()

    # Identify sub-menu element Leads
    leads_sub_menu = driver.find_element(By.XPATH, "//*[text()='Leads']")

    # Move to element and click
    actions.move_to_element(leads_sub_menu).click().perform()

    leads_header_present = By.XPATH, "//h2[@class='module-title-text']"
    wait.until(EC.visibility_of_element_located(leads_header_present))

    # Click on Additional information icon at the end of the row of the lead information.
    additional_details = driver.find_element(By.XPATH, "//tbody/tr[1]/td[10]")
    additional_details.click()

    # Wait till the pop-up loads completely
    popup = By.XPATH, "//span[@id='ui-id-6']"
    wait.until(EC.visibility_of_element_located(popup))

    # Read the popup and print the phone number displayed in it.
    phone = driver.find_element(By.XPATH, "//span[@class='phone']")
    print("Phone number is: " + phone.text)
    


    # Close the browser
    driver.close()