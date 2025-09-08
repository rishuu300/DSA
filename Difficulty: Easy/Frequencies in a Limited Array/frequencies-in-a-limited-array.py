class Solution:
    def frequencyCount(self, arr):
        N = len(arr)
        i = 0
        
        while i < N:
            if 0 < arr[i] <= N:
                j = arr[i] - 1
                
                if arr[j] > 0:
                    arr[i], arr[j] = arr[j], arr[i]
                    arr[j] = -1
                else:
                    arr[j] -= 1
                    arr[i] = 0
                    i += 1
            elif arr[i] > N:
                arr[i] = 0
                i += 1
            else:
                i += 1
        
        for i in range(N):
            arr[i] = -arr[i]
        
        return arr