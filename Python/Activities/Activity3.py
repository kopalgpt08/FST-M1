user1Input = input("Choose rock/paper/scissors:")
user2Input = input("Choose rock/paper/scissors:")
if user1Input == user2Input:
    print("Both choose the same")
elif user1Input == 'rock':
    if user2Input == 'scissors':
        print("Rock smashes scissors! You win")
    else:
        print("Paper covers rock! You win!")
elif user1Input == 'scissors':
    if user2Input == 'paper':
        print("Scissors cuts paper! You win.")
    else:
        print("Rock smashes scissors! You win!")
elif user1Input == 'paper':
    if user2Input == 'rock':
        print("Paper covers rock! You win!")
    else:
        print("Scissors cuts paper! You win!")
else:
    print("Invalid input")