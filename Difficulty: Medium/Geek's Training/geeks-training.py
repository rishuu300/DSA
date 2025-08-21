#User function Template for python3

class Solution:
    def recursion(self, arr, day, last):
        if day == 0:
            max_points = -1
            for task in range(3):
                if task != last:
                    max_points = max(max_points, arr[0][task])
            return max_points
        
        max_points = -1
        for task in range(3):
            if task != last:
                points = arr[day][task] + self.recursion(arr, day-1, task)
                max_points = max(max_points, points)
        return max_points
    
    
    def memo(self, arr, day, last, dp):
        if dp[day][last] != -1:
            return dp[day][last]
        
        if day == 0:
            max_points = -1
            for task in range(3):
                if task != last:
                    max_points = max(max_points, arr[0][task])
            
            dp[day][last] = max_points
            return dp[day][last]
        
        max_points = -1
        for task in range(3):
            if task != last:
                points = arr[day][task] + self.memo(arr, day-1, task, dp)
                max_points = max(max_points, points)
        
        dp[day][last] = max_points
        return dp[day][last]
    
    def maximumPoints(self, arr):
        n = len(arr)
        
        # return self.recursion(arr, len(arr)-1, 3)
        
        dp = [[-1] * 4 for _ in range(n)]
        return self.memo(arr, n-1, 3, dp)