numbers = [1,2,3,4,5]
print(numbers)

for item in numbers:
    print(item)

for number in range(3): # Prints the message three times
    print("Attempt", number + 1, (number + 1) * ".")

for number in range(1, 4): # Starts at 1, stops before 4, printing 3 times total
    print("Attempt", number, (number) * ".")

for number in range(1,10,2): # Counts to 10 by increments of 2, printing 5 times total
    print("Attempt", number, (number) * ".")
