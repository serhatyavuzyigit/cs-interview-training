import math

end = 2000000
start = 3
sum = 2
while True:
    if start > end:
            break
    if start%2 != 0:
        flag = 0
        for i in range(2,int(math.sqrt(start))+1):        
            if start%i==0:
                flag = 1
                break

        if flag == 0:
            sum = sum + start
        
    start = start + 1

print(sum)