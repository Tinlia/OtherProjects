heights = [161, 164, 156, 144, 158, 170, 163, 163, 157]
can_ride_coaster = [height for height in heights if height > 161]
print(can_ride_coaster)

grades = [90, 88, 62, 76, 74, 89, 48, 57]
scaled_grades = [grade + 10 for grade in grades]
print(scaled_grades)

single_digits = [n for n in range(10)]
squares = [n**2 for n in single_digits]
cubes = [n**3 for n in single_digits]
for number in single_digits: print(number)
print(squares)
print(cubes)
