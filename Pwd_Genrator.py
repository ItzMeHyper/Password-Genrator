import random
import string

def generate_password(min_Length, numbers=True, special_characters=True):
    letters = string.ascii_letters
    digits = string.digits
    special = string.punctuation

    characters = letters
    if numbers:
        characters += digits

    if special_characters:
        characters += special

    pwd = ""
    has_number = False
    has_special = False

    while len(pwd) < min_Length or (numbers and not has_number) or (special_characters and not has_special):
        new_char = random.choice(characters)
        pwd += new_char

        if new_char in digits:
            has_number = True
        elif new_char in special:
            has_special = True

    return pwd

min_Length = int(input("Enter the minimum length of the password: "))
has_numbers = input("Do you want numbers in the password? (y/n): ").lower() == "y"
special_char = input("Do you want special characters in the password? (y/n): ").lower() == "y"

pwd = generate_password(min_Length, has_numbers, special_char)

print(f"Generated password: {pwd}")
