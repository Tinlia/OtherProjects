for x in range(5):
    for y in range(3):
        print(f"({x},{y})")

sales_data = [[12, 17, 22], [2, 10, 3], [5, 12, 13]]
scoops_sold = 0

for location in sales_data:
    print(location)
    for scoops in location:
        scoops_sold += scoops
print(scoops_sold)
