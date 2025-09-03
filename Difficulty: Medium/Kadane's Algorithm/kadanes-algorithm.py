class Solution:
    def maxSubarraySum(self, arr):
        maxEnd = arr[0]
        maxSum = arr[0]
        
        for i in range(1, len(arr)):
            maxEnd = max(maxEnd + arr[i], arr[i])
            maxSum = max(maxSum, maxEnd)
        
        return maxSum