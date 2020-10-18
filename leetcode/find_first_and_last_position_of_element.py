# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

def find_index(nums, target, ind):
    if len(nums) == 0:
        return -1
    
    if nums[int(len(nums)/2)] == target:
        return ind+int(len(nums)/2)
    
    if nums[int(len(nums)/2)] < target:
        return find_index(nums[int(len(nums)/2):], target, ind+int(len(nums)/2))
    else:
        return find_index(nums[:int(len(nums)/2)], target, ind)
     

nums = [1, 3, 7, 7, 9, 9, 9, 9]
target = 9

if target<nums[0] or target>nums[len(nums)-1]:
    print([-1, -1])
elif target not in nums:
    print([-1, -1])    
else:
    ind = find_index(nums, target, 0)
    s = ind
    e = ind
    while True:
        flag = 0
        if s-1>=0:
            if nums[s-1] < target:
                flag = flag+1
            else:
                s = s-1
        else:
            s = 0
            flag = flag + 1
        
        if e+1<len(nums):
            if nums[e+1] > target:
                flag = flag + 1
            else:
                e = e + 1
        else:
            e = len(nums)-1
            flag = flag + 1
        
        if flag == 2:
            break
    
    print([s, e])


        


