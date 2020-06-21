arr = [64, 25, 12, 22, 11]
length = len(arr)

print(arr)

for i in range(length):
    min = arr[i]
    min_idx = i
    for j in range(i+1, length):
        if arr[j] < min:
            min = arr[j]
            min_idx = j

    temp = arr[i]
    arr[i] = min
    arr[min_idx] = temp
    
print(arr)