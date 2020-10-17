# https://leetcode.com/problems/median-of-two-sorted-arrays/

nums1 = [1,3,5]
nums2 = [2,4,6,7]
combined = []

i = 0
j = 0

while i<len(nums1) and j<len(nums2):
    if nums1[i] < nums2[j]:
        combined.append(nums1[i])
        i = i+1
    else:
        combined.append(nums2[j])
        j = j+1
    
if i<len(nums1):
    for k in range(i, len(nums1)):
        combined.append(nums1[k])
else:
    for k in range(j, len(nums2)):
        combined.append(nums2[k])

if len(combined)%2 == 0:
    first = combined[len(combined)/2 -1]
    second = combined[len(combined)/2]
    print((first+second) /2.0)
else:
    print(combined[len(combined)/2])