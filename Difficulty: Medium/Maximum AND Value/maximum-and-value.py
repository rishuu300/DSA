class Solution:
    def checkBits(self, arr, checker):
        count = 0
        
        for i in range(len(arr)):
            if checker & arr[i] == checker:
                count += 1
        
        return count
    
    def maxAND(self, arr):
        checker = 0
        res = 0
        
        for i in range(31, -1, -1):
            checker = (1 << i) | res
            
            count = self.checkBits(arr, checker)
            
            if count >= 2:
                res = res | checker
        
        return res