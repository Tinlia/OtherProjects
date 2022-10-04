# A simple program to practice creating and accessing objects and values from a dictionary
customer = {
    "name": "John Smith",
    "age": 30,
    "is_verified": True
}
# Obtain the value of name, if nothing is there, set it to "No User Found"
print(customer.get("name", "No User Found"))  # Retrieves a name value from the customer dictionary
print(customer.get("user", "No User Found"))  # Retrieves a name value from the customer dictionary
