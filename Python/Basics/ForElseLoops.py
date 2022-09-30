success = False
for number in range(3):
    print("Attempt", number + 1, (number + 1) * ".")
    if success:
        print("Message sent!")
        break
else:
    print("Attempted 3 times and failed")
