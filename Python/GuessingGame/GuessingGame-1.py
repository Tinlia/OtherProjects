# Guessing Game 1 - Evan Kimpton
# A basic guessing game where you have 3 chances to guess the secret number
secret_num = 9
guess_count = 1
while guess_count <= 3:
    guess_count += 1
    guess = int(input("Make a Guess: "))
    if guess == secret_num:
        print("Congratulations, you won!")
        break
    else:
        print("Incorrect guess")
else:
    print("Out of guesses. Game Over.")
