n = int(input())

if (n%2==0 and (n/2)%2==1) or n==1:
    print('NO')
elif n%2==0:
    start = 1
    stop = n/2
    l1 = []
    l2 = []
    while start <= stop:
        if start%2 == 1:
            l1.append(start)
            l1.append(n-start+1)
        else:
            l2.append(start)
            l2.append(n-start+1)
        start = start + 1    
    
    print('YES')
    print(len(l1))
    for i in range(len(l1)):
        if i==len(l1)-1:
            print(l1[i])
        else:    
            print(l1[i], end=' ')
    print(len(l2))
    for x in l2:
        print(x, end=' ')

else:
    if n==3:
        print('YES')
        print(2)
        print(1, ' ', 2)
        print(1)
        print(3)
    elif ((n-3)/2)%2==1:
        print('NO')
    else:
        l1 = []
        l2 = []
        l1.append(1)
        l1.append(2)
        l2.append(3)
        counter = 0
        start = 4
        stop = int((n+4)/2)
        while start <= stop:
            if counter%2==0:
                l1.append(start)
                l1.append(n-counter)
            else:
                l2.append(start)
                l2.append(n-counter)
            start = start + 1
            counter = counter + 1
        
        print('YES')
        print(len(l1))
        for i in range(len(l1)):
            if i==len(l1)-1:
                print(l1[i])
            else:    
                print(l1[i], end=' ')
        print(len(l2))
        for x in l2:
            print(x, end=' ')
