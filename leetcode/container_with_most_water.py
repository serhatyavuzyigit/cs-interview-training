# https://leetcode.com/problems/container-with-most-water/
height = [1,8,6,2,5,4,8,3,7]
area = -1

left = 0
right = len(height) - 1
while left<right: 
    side_length = min(height[left], height[right])
    area = max(area, side_length*(right-left))
    if height[left]<height[right]:
        left = left + 1
    else:
        right = right-1
        
print(area)