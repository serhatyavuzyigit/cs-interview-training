arr = [64, 25, 12, 22, 11]
length = len(arr)

print(arr)

for i in range(length):
    for j in range(0, length-i-1):
        if arr[j] > arr[j+1]:
            temp = arr[j]
            arr[j] = arr[j+1];
            arr[j+1] = temp

print(arr)
