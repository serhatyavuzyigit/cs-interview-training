def max_sum_non_adj(arr):
    prev, _max = 0, 0
    for x in arr:
        prev, _max = _max, max(_max, prev + x)

    return _max


numbers = [2, 4, 6, 2, 5]
max_sum = max_sum_non_adj(numbers)
print(max_sum)