#User function Template for python3

class Solution:
    def findPairs(self, arr, n):
        s = set()
        res = []
        
        for num in arr:
            s.add(num)
            
            if num != 0 and -num in s:
                if num < 0:
                    res.append(num)
                    res.append(-num)
                else:
                    res.append(-num)
                    res.append(num)
        
        return res