class Solution:
    def search(self, arr, key):
        low, high = 0, len(arr)-1
        
        while low <= high:
            mid = (low+high)//2
            
            if arr[mid] == key:
                return mid
            elif arr[low] == arr[mid] == arr[high]:
                low += 1
                high -= 1
            elif arr[low] <= arr[mid]:
                if arr[low] <= key < arr[mid]:
                    high = mid-1
                else:
                    low = mid+1
            else:
                if arr[mid] < key <= arr[high]:
                    low = mid+1
                else:
                    high = mid-1
        
        return -1