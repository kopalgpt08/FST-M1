import pytest
import math
# sum of the two numbers
num1=40
num2=60
def test_addition():
    sum=num1+num2

    assert sum==100

#Difference of two numbers
def test_subtraction():
    differnce=num1-num2

    assert differnce==-20   

#Product of two numbers
	
@pytest.mark.activity
def test_multiplication():
	prod = num1 * num2
 
	# Assertion
	assert prod == 2400
        
#Quotient of two numbers
    # Division test
	
@pytest.mark.activity
def test_division():
  
	# Initialize two numbers
	num1 = 100
	num2 = 5
    
	# Divide them
	quot = num1 / num2
	# Assertion
	assert quot == 20