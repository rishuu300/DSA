class Solution:
    def recursion(self, grid, row, col):
        if row < 0 or col < 0 or grid[row][col] == 1:
            return 0
            
        if row == 0 and col == 0:
            return 1
        
        
        up = self.recursion(grid, row-1, col)
        left = self.recursion(grid, row, col-1)
        
        return up + left
    
    
    def memo(self, grid, row, col, dp):
        if row < 0 or col < 0 or grid[row][col] == 1:
            return 0
        
        if row == 0 and col == 0:
            return 1
        
        if dp[row][col] != -1:
            return dp[row][col]
        
        up = self.memo(grid, row-1, col, dp)
        left = self.memo(grid, row, col-1, dp)
        
        dp[row][col] = up + left
        return dp[row][col]
    
    def uniquePaths(self, grid):
        n = len(grid)
        m = len(grid[0])
        
        # return self.recursion(grid, n-1, m-1)
        
        dp = [[-1 for _ in range(m)] for _ in range(n)]
        return self.memo(grid, n-1, m-1, dp)