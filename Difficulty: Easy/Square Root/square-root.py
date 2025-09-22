class Solution:
    def floorSqrt(self, n): 
        low, high = 1, n
        answer = 1
        
        while low <= high:
            mid = (low + high) // 2
            
            if mid * mid <= n:
                answer = mid
                low = mid + 1
            else:
                high = mid - 1
        
        return answer