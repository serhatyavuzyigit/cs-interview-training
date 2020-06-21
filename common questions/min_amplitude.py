#Given an Array A, find the minimum amplitude you can get after changing up to 3 elements. 
#Amplitude is the range of the array (basically difference between largest and smallest element).

numbers = [-1, 3, -1, 8, 5, 4]
numbers.sort()
min = 0
size = len(numbers)

# remove first 3 elements and look at the difference between max and min
intr_numbers = numbers[3:]
min = intr_numbers[len(intr_numbers)-1] - intr_numbers[0]

# remove last 3 elements and look at the difference between max and min
intr_numbers = numbers[0:size-3]
_min = intr_numbers[len(intr_numbers)-1] - intr_numbers[0]
if _min < min:
	min = _min

# remove last 2 and first 1 elements and look at the difference between max and min
intr_numbers = numbers[1:size-2]
_min = intr_numbers[len(intr_numbers)-1] - intr_numbers[0]
if _min < min:
	min = _min

# remove last 1 and first 2 elements and look at the difference between max and min
intr_numbers = numbers[2:size-1]
_min = intr_numbers[len(intr_numbers)-1] - intr_numbers[0]
if _min < min:
	min = _min


print(min)