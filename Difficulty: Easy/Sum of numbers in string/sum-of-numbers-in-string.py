class Solution:
    def findSum(self, s):
        res = 0
        temp = ""
        
        for ch in s:
            if ch.isnumeric():
                temp += ch
            else:
                if temp:
                    res += int(temp)
                    temp = ""
        
        if temp:
            res += int(temp)
        
        return res