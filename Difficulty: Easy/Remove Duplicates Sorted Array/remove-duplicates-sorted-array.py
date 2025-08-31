class Solution:
    def removeDuplicates(self, arr):
        length = 0
        
        for index in range(len(arr)):
            if arr[length] != arr[index]:
                length += 1
                arr[length], arr[index] = arr[index], arr[length]
        
        return arr[:length+1]