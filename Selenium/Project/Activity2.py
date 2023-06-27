#Get the url of the header image
#Goal: Print the url of the header image to the console

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
  
  # Get the xpath of the header image.
  srcImage =driver.find_element(By.XPATH,"//img[@alt='SuiteCRM']")

  #getAttribute() to get src of image and print the url to the console
  print("Url of the header image is: "+ srcImage.get_attribute("src"))

  # Close the browser
  driver.close()