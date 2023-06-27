#Logging into the site
#Goal: Open the site and login with the credentials provided


# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

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
  
  #Verify that the homepage has opened.
  expectedTitle="SuiteCRM";
  print("Title of the WebPage is:"+driver.title)
  if driver.title is not None and expectedTitle in driver.title:
    print("Home page is opened")
  else:
    print("Home page could not open.")
    
  # Close the browser
  driver.close()