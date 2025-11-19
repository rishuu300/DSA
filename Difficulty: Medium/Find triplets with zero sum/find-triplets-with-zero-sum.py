class Solution:
    def findTriplets(self, arr):
        n = len(arr)
        arr.sort()
        
        for i in range(n-2):
            low, high = i+1, n-1
            
            while low < high:
                total_sum = arr[i] + arr[low] + arr[high]
                
                if total_sum == 0:
                    return True
                elif total_sum < 0:
                    low += 1
                else:
                    high -= 1
        
        return False