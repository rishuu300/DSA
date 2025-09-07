# User function Template for python3

class Solution:
    def findEquilibrium(self, arr):
        total_sum = 0
        
        for i in range(len(arr)):
            total_sum += arr[i]
        
        left_sum = 0
        
        for i in range(len(arr)):
            if left_sum == total_sum - arr[i]:
                return i
            
            left_sum += arr[i]
            total_sum -= arr[i]
        
        return -1