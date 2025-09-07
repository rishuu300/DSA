class Solution:
    def maxSubarraySum(self, arr, k):
        max_sum = -1
        
        curr_sum = 0
        for i in range(k):
            curr_sum += arr[i]
        
        max_sum = max(max_sum, curr_sum)
        
        for i in range(k, len(arr)):
            curr_sum += (arr[i] - arr[i-k])
            
            max_sum = max(max_sum, curr_sum)
        
        return max_sum