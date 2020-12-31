# Given an array of integers and a value, determine if there are any two integers in the array whose sum is equal to the given value. 
# Return true if the sum exists and return false if it does not. Consider this array and the target sums:

def find_sum_of_two(A, val):
    pairs = {}
    result = []
    for x in A:
        
        if (val-x) in pairs:
            a = []
            a.append(x)
            a.append(val-x)
            result.append(a)

        elif not x in pairs:
            pairs[x] = val-x

    print(result)