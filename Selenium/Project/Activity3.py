#Get the copyright text
#Goal: Print the first copyright text in the footer to the console


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
  
  #Get the xpath of  footer
  footer =driver.find_element(By.XPATH,"//div[@class='p_login_bottom']")

  #getText() to Get the first copyright text in the footer by using tagname a
  firstCopyrightText=footer.find_elements(By.TAG_NAME,"a")[0].text
  print("The first copyright text in the footer is:"+firstCopyrightText)

  # Close the browser
  driver.close()