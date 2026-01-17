#User function Template for python3
class Solution:
    def subarraySum(self, arr, target):
        total_sum = 0
        start = 0
        
        for i in range(len(arr)):
            total_sum += arr[i]
            
            while total_sum > target and start < i:
                total_sum -= arr[start]
                start += 1
            
            if total_sum == target:
                return [start+1, i+1]
        
        return [-1]