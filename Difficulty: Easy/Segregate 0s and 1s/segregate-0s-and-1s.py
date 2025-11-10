#User function Template for python3

class Solution:
    def segregate0and1(self, arr):
        n = len(arr)
        i, j = 0, n-1
        
        while True:
            while i < n:
                if arr[i] == 1:
                    break
                i += 1
            
            while j >= 0:
                if arr[j] == 0:
                    break
                j -= 1
            
            if i >= j:
                break
            
            arr[i], arr[j] = arr[j], arr[i]