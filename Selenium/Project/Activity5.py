#Getting colors
#Goal: Get the color of the navigation menu


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
  
  # Get the color of the navigation menu
  nav_bar_xpath = driver.find_element(By.XPATH, "//nav[@role='navigation']").value_of_css_property("color")
  print("The color of the navigation menu is: " + nav_bar_xpath)
  
  # Close the browser
  driver.close()