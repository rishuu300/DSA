class Solution:
    def maxOfMins(self, arr):
        n = len(arr)
        stack = []
        maxes = [0] * n
        
        for i in range(n):
            while stack and arr[i] < arr[stack[-1]]:
                top = stack.pop()
                rng = i - stack[-1] - 1 if stack else i
                maxes[rng - 1] = max(maxes[rng - 1], arr[top])
            
            stack.append(i)
        
        while stack:
            top = stack.pop()
            rng = n - stack[-1] - 1 if stack else n
            maxes[rng - 1] = max(maxes[rng - 1], arr[top])
        
        for i in range(n-2, -1, -1):
            maxes[i] = max(maxes[i], maxes[i+1])
        
        return maxes