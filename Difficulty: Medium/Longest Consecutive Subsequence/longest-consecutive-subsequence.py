 #User function Template for python3
 
class Solution:
    def longestConsecutive(self,arr):
        s = set(arr)
        
        res = 0
        
        for element in arr:
            if element in s and element-1 not in s:
                curr = element
                count = 0
                
                while curr in s:
                    s.remove(curr)
                    curr += 1
                    count += 1
                
                res = max(res, count)
        
        return res