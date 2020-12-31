# Given two sorted linked lists, merge them so that the resulting linked list is also sorted

def merge_sorted(list1, list2):
    index1, index2 = 0, 0
    result_list = []

    while index1 < len(list1) and index2 < len(list2):
        if list1[index1] < list2[index2]:
            result_list.append(list1[index1])
            index1 += 1
        else :
            result_list.append(list2[index2])
            index2 += 1
    
    if index1 < len(list1):
        result_list.append(list1[index1:])
    else:
        result_list.append(list2[index2:])
    
    print(result_list)

