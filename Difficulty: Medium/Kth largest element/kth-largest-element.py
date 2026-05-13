import heapq

class Solution:
    def kthLargest(self, arr, k):
        heap = []
        
        for i in range(k):
            heapq.heappush(heap, arr[i])
        
        for i in range(k, len(arr)):
            heapq.heappush(heap, arr[i])
            
            heapq.heappop(heap)
        
        return heap[0]