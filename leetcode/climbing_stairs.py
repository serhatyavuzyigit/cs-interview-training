# https://leetcode.com/problems/climbing-stairs/

def climbStairs(self, n: int) -> int:
        if n == 0: 
            return 0
        if n == 1: 
            return 1
        if n == 2: 
            return 2
    
        dp_arr = []
        dp_arr.append(1)
        dp_arr.append(2)
        
        for i in range(2, n):
            dp_arr.append(dp_arr[i-1] + dp_arr[i-2])
        
        return dp_arr[n-1]