class Solution:
    def pushZerosToEnd(self, arr):
        index = 0
        
        for i in range(len(arr)):
            if arr[i] != 0:
                arr[i], arr[index] = arr[index], arr[i]
                index += 1