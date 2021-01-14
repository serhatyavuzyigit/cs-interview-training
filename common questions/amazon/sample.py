def canFormArray(arr, pieces):
    counter = 0
    for l in pieces:
        if len(l) == 1:
            if not l[0] in arr:
                return False
            else:
                counter += 1
        else:
            if not l[0] in arr:
                return False
            else:
                startIndex = arr.index(l[0])
                in_count = 0
                while startIndex < len(arr) and in_count<len(l):
                    if l[in_count] != arr[startIndex]:
                        return False
                    startIndex +=1
                    in_count += 1
                if in_count == len(l):
                    counter += len(l)
                else:
                    return False
    if counter == len(arr):
        return True
    else:
        return False
            
arr = [1, 3, 5, 7]
pieces = [[2, 4, 6, 8]]

print(canFormArray(arr, pieces))