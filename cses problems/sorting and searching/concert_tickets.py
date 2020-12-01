
n_m = input()
tickets_input = input()
customers_input = input()

tickets = list(map(int, tickets_input.split()))
customers = list(map(int, customers_input.split()))

tickets.sort()

for cust in customers:
    if tickets[0] > cust:
        print(-1)
    elif cust in tickets:
        print(cust)
        tickets.remove(cust)
    else:
        ind = 0
        for i in range(len(tickets)):
            if tickets[i] > cust:
                ind = i-1
                break
        print(tickets[ind])
        del tickets[ind]    

