#Given a list of numbers and a number k, return whether any two 
#numbers from the list add up to k.
#For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
#Bonus: Can you do this in one pass?

def isTwoSumEqualToK(numbers, k):
    complementsToK = {}
    for i in range(len(numbers)):
        current_number = numbers[i]
        complement = k - current_number
        complementsToK[complement] = current_number
        if current_number in complementsToK:
            return True
        
    return False

numbers = [10, 15, 3, 6]
k = 17

val = isTwoSumEqualToK(numbers, k)
print(val)