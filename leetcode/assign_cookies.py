class assign_cookies:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        
        g.sort()
        s.sort()
        
        print(g)
        print(s)
        
        i = 0
        j = 0
        count = 0
        
        while i < len(g) and j < len(s):
            if(g[i] <= s[j]):
                count = count + 1
                i = i + 1
                j = j + 1
            else:
                j = j + 1
        
        return count