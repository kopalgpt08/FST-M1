fruit_box={
    "apple": 50,
    "orange": 25,
    "grapes": 30,
    "peaches": 20
}
input_value=input("Enter the fruit to check:")
 
if(input_value in fruit_box):
    print("Yes, entered fruit is available at price",fruit_box[input_value])
else:
    print("No, entered fruit is not available")