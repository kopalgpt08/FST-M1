my_tuple = tuple(input('Enter space-separated words: ').split())

print(my_tuple)   
print("Elements that are divisible by 5:")
for num in my_tuple:
    if (int(num) % 5 == 0):
        print(num)