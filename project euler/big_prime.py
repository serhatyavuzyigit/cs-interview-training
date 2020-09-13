import math
times = 10001
start = 2
counter = 0
while True:
    flag = 0
    for i in range(1,int(math.sqrt(start))+1):
        if i!=1 and i!=start:
            if start%i==0:
                flag = 1
                break
    
    if flag == 0:
        counter = counter + 1
        
    
    if counter == times:
        break

    start = start + 1

print(start)