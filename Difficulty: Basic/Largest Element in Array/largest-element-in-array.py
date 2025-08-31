class Solution:
    def largest(self, arr):
        largest = 0
        
        for element in arr:
            if element > largest:
                largest = element
        
        return largest
