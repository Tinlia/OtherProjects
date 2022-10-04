# Car Game 1 - Evan Kimpton
# A basic program to practice forever loops
print("Type 'Help' for a list of commands")
while True:
    command = str.lower((input(">")))
    if command == "help":
        print("Start - To start the car")
        print("Stop - To stop the car")
        print("Quit - To exit the program")
    elif command == "start":
        print("The car has started")
    elif command == "stop":
        print("The car has stopped")
    elif command == "quit":
        print("Goodbye!")
        break
    else:
        print("I don't understand that command...")
