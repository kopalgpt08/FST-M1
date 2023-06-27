#Verify the website title
#Goal: Read the title of the website and verify the text

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

  #  Read the title of the website and verify the text
  print("Home page title:"+driver.title)
  
  try:
    title = driver.title
    assert 'SuiteCRM' in title
    print('Page Title matched,assertion pass')
  except Exception as e:
    print('Page title does not matched,Assertion test failed', format(e))

  # Close the browser
  driver.close()