def closest_pair(list1, list2, target):
    l, r = 0, len(list2)-1
    diff = 9999999999
    while l<len(list1) and r>-1:
        if abs(list1[l] + list2[r] - target) < diff:
            diff = abs(list1[l] + list2[r] - target)
            result_l, result_r = l, r

        if list1[l] + list2[r] > target:
            r -= 1
        else :
            l += 1
    
    print('pair: ', str(list1[result_l]), ' ', str(list2[result_r]))

