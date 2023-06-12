lst = []
num = int(input('How many numbers: '))

for n in range(num):
    numbers_list = int(input('Enter number '))
    lst.append(numbers_list)

# Get first element in list
firstElement = lst[0]
# Get last element in list
lastElement = lst[-1]
 
# Check if first and last element are equal
if (firstElement == lastElement):
    print(True)
else:
    print(False)