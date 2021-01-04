import math

def is_prime(number):
    if number == 1:
        return False
    for i in range(1, int(math.sqrt(number))+1):
        if i!=1 and number%i == 0:
            return False
    return True

def get_lines(file_name):
    _lines = []
    fID = open(file_name, 'r')

    for l in fID:
        line = l.split()
        nums = []
        for i in range(len(line)):
            nums.append(int(line[i]))
        _lines.append(nums)
    
    return _lines


lines = get_lines('input.txt')
max_sums = {}
for i in range(len(lines)):
    for j in range(len(lines[i])):
        key = 'row: ' + str(i) + ' column: ' + str(j)
        if i == 0:
            if not is_prime(lines[i][j]):
                max_sums[key] = lines[i][j]
            else:
                max_sums[key] = -1
        else:
            if j == 0:
                if is_prime(lines[i][j]):
                    max_sums[key] = -1
                else:
                    look_key = 'row: ' + str(i-1) + ' column: ' + str(j)
                    if max_sums[look_key] == -1:
                        max_sums[key] = -1
                    else:
                        max_sums[key] = max_sums[look_key]+lines[i][j]
            elif j == len(lines[i])-1:
                if is_prime(lines[i][j]):
                    max_sums[key] = -1
                else:
                    look_key = 'row: ' + str(i-1) + ' column: ' + str(j-1)
                    if max_sums[look_key] == -1:
                        max_sums[key] = -1
                    else:
                        max_sums[key] = max_sums[look_key]+lines[i][j]
            else:
                if is_prime(lines[i][j]):
                    max_sums[key] = -1
                else:
                    look_key_1 = 'row: ' + str(i-1) + ' column: ' + str(j-1)
                    look_key_2 = 'row: ' + str(i-1) + ' column: ' + str(j)

                    if max_sums[look_key_1] == -1 and max_sums[look_key_2] == -1:
                        max_sums[key] = -1
                    elif max_sums[look_key_1] == -1:
                        max_sums[key] = max_sums[look_key_2] + lines[i][j]
                    elif max_sums[look_key_2] == -1:
                        max_sums[key] = max_sums[look_key_1] + lines[i][j]
                    else:
                        max_sums[key] = max(max_sums[look_key_1], max_sums[look_key_2]) + lines[i][j]

max_sum = 0
last_row = 'row: ' + str(len(lines)-1)
for key in max_sums.keys():
    if last_row in key:
        if max_sums[key] > max_sum:
            max_sum = max_sums[key]


print(max_sum)    

