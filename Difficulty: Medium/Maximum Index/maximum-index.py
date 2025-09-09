class Solution:
    def maxIndexDiff(self, arr):
        n = len(arr)
        left_min = [0]*n
        right_max = [0]*n
        
        left_min[0] = arr[0]
        right_max[n-1] = arr[n-1]
        
        for i in range(1, n):
            left_min[i] = min(left_min[i-1], arr[i])
            
            right_max[n-i-1] = max(right_max[n-i], arr[n-i-1])
        
        max_diff = -1
        i, j = 0, 0
        
        while i<n and j<n:
            if left_min[i] <= right_max[j]:
                max_diff = max(max_diff, j-i)
                j += 1
            else:
                i += 1
        
        return max_diff