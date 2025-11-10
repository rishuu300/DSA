class Solution:
    def lomuto(self, arr, low, high):
        pivot = arr[high]
        i = low-1
        
        for j in range(low, high):
            if arr[j] < pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]
        
        i += 1
        arr[i], arr[high] = arr[high], arr[i]
        return i
    
    def kthSmallest(self, arr, k):
        low, high = 0, len(arr)-1
        
        while low <= high:
            partition = self.lomuto(arr, low, high)
            
            if partition == k-1:
                return arr[partition]
            elif partition > k-1:
                high = partition-1
            else:
                low = partition+1
        
        return -1