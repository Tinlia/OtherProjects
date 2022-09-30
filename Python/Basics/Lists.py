names = ["John", "Bob", "Evan", "Myles", "Kelly"]
names[1] = "Cooper"
print(names[0:3]) # Prints John, Cooper, Evan

numbers = [1,2,3,4,5]
numbers.append(6)
numbers.insert(0, -1)
numbers.remove(3)
print(numbers)
numbers.clear()
print(numbers)

print(1 in numbers) # Prints True
print(len(numbers)) # Prints 0, since the list is cleared
