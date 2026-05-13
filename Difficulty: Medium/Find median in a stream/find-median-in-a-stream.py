import heapq

class Solution:
    def getMedian(self, arr):
        max_heap = [] # Store smaller half
        min_heap = [] # Store larger half
        
        result = []
        
        for num in arr:
            heapq.heappush(max_heap, -num)
            
            heapq.heappush(min_heap, -heapq.heappop(max_heap))
            
            if len(min_heap) > len(max_heap):
                heapq.heappush(max_heap, -heapq.heappop(min_heap))
            
            if len(max_heap) == len(min_heap):
                median = (-max_heap[0] + min_heap[0]) / 2
                result.append(median)
            else:
                median = float(-max_heap[0])
                result.append(median)
        
        return result