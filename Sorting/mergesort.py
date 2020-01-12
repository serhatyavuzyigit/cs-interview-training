print('mergesort')

number_arr = [54, 76, 98, 32, 64, 0, 22, 14, 52]

def merge(arr, l, m, r):
    # create two temp arrays and put data into them
    len1 = m - l + 1
    len2 = r - m

    left_arr = []
    right_arr = []

    for i in range(len1):
        left_arr[i] = arr[l + i]

    for i in range(len2):
        right_arr[i] = arr[m + 1 + i]

    # change data of actual array for split arrays
    i = 0
    j = 0
    k = l
    while i < len1 and j < len2:
        if left_arr[i] < right_arr[j]:
            arr[k] = left_arr[i]
            i+=1
        else:
            arr[k] = right_arr[j]
            j+=1
        k+=1

    while i < len1:
        arr[k] = left_arr[i]
        i+=1
        k+=1

    while j < len2:
        arr[k] = right_arr[j]
        j+=1
        k+=1

def mergesort(arr, l, r):
    if r > l:
        m = (l+r) / 2           # find middle element from array

        mergesort(arr, l, m)    # call mergesort for first half

        mergesort(arr, m+1, r)    # call mergesort for second half

        merge(arr, l, m, r)

print(len(number_arr))
mergesort(number_arr, 0, len(number_arr)-1)
