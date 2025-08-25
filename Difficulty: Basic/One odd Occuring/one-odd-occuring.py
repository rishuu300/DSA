class Solution:
    def getOddOccurrence(self, arr):
        odd = 0
        
        for element in arr:
            odd ^= element
        
        return odd