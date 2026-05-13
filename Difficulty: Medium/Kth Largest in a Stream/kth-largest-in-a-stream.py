import heapq

class Solution:
    def kthLargest(self, arr, k):
        n = len(arr)
        
        heap = []
        result = [0]*n
        
        for i in range(k):
            heapq.heappush(heap, arr[i])
            
            if i != k-1:
                result[i] = -1
        
        for i in range(k-1, n):
            if arr[i] > heap[0] and i != k-1:
                heapq.heappop(heap)
                heapq.heappush(heap, arr[i])
            
            result[i] = heap[0]
        
        return result