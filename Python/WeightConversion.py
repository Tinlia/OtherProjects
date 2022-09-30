weight = int(input("Weight: "))
type = input("(K)g or (L)bs: ")
if type.upper() == "K":
    weight = weight * 2.2
    print("Weight in lbs: " + str(weight))
elif type.upper() == "L":
    weight = weight / 2.2
    print("Weight in kg: " + str(weight))
else:
    print("Invalid Input")
