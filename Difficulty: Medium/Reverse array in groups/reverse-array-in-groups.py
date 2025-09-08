class Solution:
    def reverse(self, arr, i, j):
        while i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
    
    def reverseingroups(self, arr, k):
        i = 0
        j = k
        n = len(arr)
        
        while j < n:
            self.reverse(arr, i, j-1)
            i += k
            j += k
        
        self.reverse(arr, i , n-1)