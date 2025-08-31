class Solution:
    def reverseArray(self, arr):
        i, j = 0, len(arr)-1
        
        while i < j:
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1