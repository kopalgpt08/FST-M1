#Traversing tables
#Goal: Open the accounts page and print the contents of the table


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
    
    # Identify sub-menu element Accounts
    accounts_sub_menu = driver.find_element(By.XPATH, "//*[text()='Accounts']")

    # Move to element and click
    actions.move_to_element(accounts_sub_menu).click().perform()

    accounts_header_present = By.XPATH, "//h2[@class='module-title-text']"
    wait.until(EC.visibility_of_element_located(accounts_header_present))

    # Finding number of rows in a web table.
    all_rows = driver.find_elements(By.XPATH, "//table[@class='list view table-responsive']/tbody/tr")
    print("Total data rows found in table: " + str(len(all_rows)))

    # Print the names of the first 5 odd-numbered rows of the table to the console.
    row_index = 0
    print("Print the names of the first 5 odd-numbered rows\nof the table to the console:")
    for i in range(1, len(all_rows) + 1, 2):
        # Only first 5 rows are needed
        if row_index < 5:
            # Find the number of columns in each row and print them
            all_columns_in_row = driver.find_elements(By.XPATH, "//table[@class='list view table-responsive']/tbody/tr[" + str(i) + "]/td")
            for column in all_columns_in_row:
                print(column.text, end=" ")
            print()
        row_index += 1

    # Close the browser
    driver.close()