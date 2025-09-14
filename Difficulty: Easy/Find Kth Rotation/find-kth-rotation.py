class Solution:
    def findKRotation(self, arr):
        low, high = 0, len(arr)-1
        mini, index = 1e10+1, -1
        
        while low <= high:
            mid = (low+high)//2
            
            if arr[low] <= arr[mid]:
                if arr[low] <= mini:
                    mini = arr[low]
                    index = low
                
                low = mid+1
            else:
                if arr[mid] <= mini:
                    mini = arr[mid]
                    index = mid
                
                high = mid-1
        
        return index