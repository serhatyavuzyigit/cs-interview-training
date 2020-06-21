# Problem 6

first_hundred_sum = (100 * 101) / 2
first_hundred_sum_square = first_hundred_sum**2

square_sum = 0
for i in range(101):
    square_sum = square_sum + i**2

print(first_hundred_sum_square - square_sum)