class Solution:
    def first(self, arr, x, n):
        low, high = 0, n-1
        ans = -1
        
        while low <= high:
            mid = (low+high)//2
            
            if arr[mid] == x:
                ans = mid
                high = mid-1
            elif arr[mid] > x:
                high = mid-1
            else:
                low = mid+1
        
        return ans
    
    def second(self, arr, x, n):
        low, high = 0, n-1
        ans = -1
        
        while low <= high:
            mid = (low+high)//2
            
            if arr[mid] == x:
                ans = mid
                low = mid+1
            elif arr[mid] <= x:
                low = mid+1
            else:
                high = mid-1
        
        return ans
    
    def find(self, arr, x):
        n = len(arr)
        
        first = self.first(arr, x, n)
        
        if first == -1:
            return [-1, -1]
        
        second = self.second(arr, x, n)
        
        return [first, second]
    
    def countFreq(self, arr, target):
        result = self.find(arr, target)
        
        if result[0] == -1 or result[1] == -1:
            return 0
        
        return result[1] - result[0] + 1