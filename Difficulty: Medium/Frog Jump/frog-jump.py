#User function Template for python3
class Solution:
    def memo(self, height, index, n, dp):
        if dp[index] != -1:
            return dp[index]
        
        if index == n-1:
            return 0
        
        if index >= n:
            return 2**31 - 1
        
        left = self.memo(height, index+1, n, dp) + abs(height[index] - height[index+1])
        
        right = 2**31 - 1
        if  index < n-2:
            right = self.memo(height, index+2, n, dp) + abs(height[index] - height[index+2])
        
        return min(left, right)
    
    
    def table(self, height, n):
        dp = [0]*n
        dp[n-1] = 0
        dp[n-2] = abs(height[n-2] - height[n-1])
        
        for i in range(n-3, -1, -1):
            left = dp[i+1] + abs(height[i] - height[i+1])
            right = dp[i+2] + abs(height[i] - height[i+2])
            
            dp[i] = min(left, right)
        
        return dp[0]
    
    def minCost(self, height):
        n = len(height)
        dp = [-1]*(n+1)
        # return self.memo(height, 0, n, dp)
        return self.table(height, n)