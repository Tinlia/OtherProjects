# A basic program to practice the use of the modulo(%) operator
i = 0
for x in range(1, 10):
    if x % 2 == 0:
        i += 1
        print(x)
print(f"There are {i} even numbers")
