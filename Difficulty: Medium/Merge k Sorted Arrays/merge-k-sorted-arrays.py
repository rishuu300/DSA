import heapq

class Solution:
    def mergeArrays(self, arr):
        heap = []
        
        for i, row in enumerate(arr):
            heapq.heappush(heap, (row[0], 0, i))
        
        result = []
        
        while heap:
            element, pos, arr_idx = heapq.heappop(heap)
            
            result.append(element)
            
            if pos + 1 < len(arr[arr_idx]):
                next_value = arr[arr_idx][pos + 1]
                
                heapq.heappush(heap, (next_value, pos + 1, arr_idx))
        
        return result    