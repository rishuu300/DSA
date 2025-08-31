#User function Template for python3

class Solution:
    def rotate(self, arr):
        last_element = arr[len(arr)-1]
        prev = arr[0]
        
        for i in range(1, len(arr)):
            curr = arr[i]
            arr[i] = prev
            prev = curr
        
        arr[0] = last_element