#User function Template for python3

class Solution:
    def subArrayExists(self, arr):
        total_sum = 0
        s = set()
        
        for element in arr:
            total_sum += element
            
            if total_sum in s:
                return True
            
            if total_sum == 0:
                return True
            
            s.add(total_sum)
        
        return False