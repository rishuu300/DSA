class Solution:
    def getMaxArea(self, arr):
        n = len(arr)
        
        stack = []
        largest = -float('inf')
        
        for i in range(n):
            while stack and arr[i] <= arr[stack[-1]]:
                top = stack.pop()
                curr = arr[top] * (i - stack[-1] - 1) if stack else arr[top] * i
                largest = max(largest, curr)
            
            stack.append(i)
        
        while stack:
            top = stack.pop()
            curr = arr[top] * (n - stack[-1] - 1) if stack else arr[top] * n
            largest = max(largest, curr)
        
        return largest