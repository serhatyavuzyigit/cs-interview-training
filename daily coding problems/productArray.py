#Given an array of integers, return a new array such that 
#each element at index i of the new array is the product of 
#all the numbers in the original array except the one at i.

#For example, if our input was [1, 2, 3, 4, 5], the expected 
#output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1],
#the expected output would be [2, 3, 6].

numbers_arr = [1, 2, 3, 4, 5]
product_arr = []

print(numbers_arr)

product = 1
for x in numbers_arr:
    product = product * x

for x in numbers_arr:
    product_arr.append(product/x)

print(product_arr)