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
  driver.get("https://training-support.net")

  #  Get the title of the page and print it to the console
  print("Home page title:"+driver.title)
  #Find the "About Us" button on the page using it's id. and click on it
  driver.find_element(By.ID,"about-link").click()

  #Print the title of the new page
  print("New page title is: ", driver.title) 

  # Close the browser
  driver.quit()