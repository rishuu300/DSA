class Solution:
    def modified(self, s):
        count, res = 1, 0
        prev = s[0]
        
        for i in range(1, len(s)):
            char = s[i]
            
            if char == prev:
                count += 1
            else:
                prev = char
                count = 1
            
            if count == 3:
                res += 1
                count = 1
        
        if count == 3:
            res += 1
        
        return res