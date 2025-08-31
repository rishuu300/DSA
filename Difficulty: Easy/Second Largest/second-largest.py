class Solution:
    def getSecondLargest(self, arr):
        largest = arr[0]
        second_largest = -1
        
        for element in arr:
            if element > largest:
                second_largest = largest
                largest = element
            elif second_largest < element < largest:
                second_largest = element
        
        return second_largest