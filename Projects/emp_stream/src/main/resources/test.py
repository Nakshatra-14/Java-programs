# import csv
# import random
# from datetime import datetime, timedelta

# def generate_employee_data(num_records=1000):
#     first_names = ["Aarav", "Vihaan", "Aditya", "Ananya", "Diya", "Ishani", "Arjun", "Sai", "Ishaan", "Aadhya"]
#     last_names = ["Sharma", "Verma", "Gupta", "Patel", "Reddy", "Singh", "Kumar", "Iyer", "Nair", "Joshi"]
#     departments = ["Engineering", "Marketing", "Finance", "Sales", "HR", "Legal", "Product", "Support"]
#     genders = ["Male", "Female"]

#     with open('employees.csv', mode='w', newline='') as file:
#         writer = csv.writer(file)
#         # Writing the Header
#         writer.writerow(['empCode', 'id', 'fName', 'lName', 'gender', 'dob', 'dateOfJoining', 'email', 'phNo', 'dept'])

#         for i in range(1, num_records + 1):
#             f_name = random.choice(first_names)
#             l_name = random.choice(last_names)
            
#             emp_code = f"EMP{i:04d}"
#             emp_id = 10000 + i
#             gender = random.choice(genders)
            
#             # Generate random dates
#             dob = datetime(1970, 1, 1) + timedelta(days=random.randint(0, 12000))
#             doj = datetime(2010, 1, 1) + timedelta(days=random.randint(0, 5000))
            
#             email = f"{f_name.lower()}.{l_name.lower()}.{i}@company.com"
#             ph_no = 900000000 + i  # Simple unique phone number logic
#             dept = random.choice(departments)

#             writer.writerow([
#                 emp_code, 
#                 emp_id, 
#                 f_name, 
#                 l_name, 
#                 gender, 
#                 dob.strftime('%Y-%m-%d'), 
#                 doj.strftime('%Y-%m-%d'), 
#                 email, 
#                 ph_no, 
#                 dept
#             ])

#     print(f"Successfully generated {num_records} unique records in 'employees.csv'")

# generate_employee_data(1000)

from random import randint, seed

seed(42)

numbers = set()

def gen():
    # Indian mobile numbers typically start with 6-9
    first = str(randint(6, 9))
    rest = "".join(str(randint(0, 9)) for _ in range(9))
    return "+91" + first + rest

while len(numbers) < 1000:
    numbers.add(gen())

import pandas as pd

df = pd.DataFrame(sorted(numbers), columns=["phone_number"])
file_path = "indian_phone_numbers.csv"
df.to_csv(file_path, index=False)

file_path, df.head()