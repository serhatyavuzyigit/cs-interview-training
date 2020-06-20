from fractions import gcd
import math

def lowest_common_multiple(a,b):
    return a*b//math.gcd(a,b)

# 1 2 3 4 5 6 7 8 9 10 -> 2520
# 11 12 13 14 15 16 17 18 19 20

nums = [11, 12, 13, 14, 15, 16 ,17, 18, 19, 20]
curr = 2520
for num in nums:
    curr = lowest_common_multiple(curr, num)

print(curr)