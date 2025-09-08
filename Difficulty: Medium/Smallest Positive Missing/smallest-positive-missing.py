class Solution:
    def missingNumber(self, arr):
        N = len(arr)
        
        for i in range(N):
            CI = arr[i] - 1
            
            while 0 < arr[i] <= N and arr[i] != arr[CI]:
                arr[i], arr[CI] = arr[CI], arr[i]
                CI = arr[i] - 1
        
        for i in range(N):
            if arr[i] != i+1:
                return i+1
        
        return N+1