# You are given an array of positive numbers from 1 to n, such that all numbers from 1 to n are present except one number x. 
# You have to find x. The input array is not sorted. Look at the below array and give it a try before checking the solution.

def find_missing(input_list):
    n = len(input_list) + 1
    total_sum = (n*(n+1)) / 2
    list_sum = 0
    for x in input_list:
        list_sum += x
    
    print('missing element: ', str(total_sum - list_sum))

