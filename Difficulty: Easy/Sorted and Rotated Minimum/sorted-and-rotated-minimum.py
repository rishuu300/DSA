#User function Template for python3

class Solution:
    def findMin(self, arr):
        low, high = 0, len(arr)-1
        ans = 1e10+1
        
        while low <= high:
            mid = (low+high)//2
            
            if arr[low] <= arr[high]:
                return min(ans, arr[low])
            
            if arr[low] <= arr[mid]:
                ans = min(ans, arr[low])
                low = mid+1
            else:
                ans = min(ans, arr[mid])
                high = mid-1
        
        return ans