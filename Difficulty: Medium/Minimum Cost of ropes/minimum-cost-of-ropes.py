import heapq

class Solution:
    def minCost(self, arr):
        heap = []
        
        for num in arr:
            heapq.heappush(heap, num)
        
        cost = 0
        
        while len(heap) >= 2:
            num1 = heapq.heappop(heap)
            num2 = heapq.heappop(heap)
            
            total = num1 + num2
            
            cost += total
            
            heapq.heappush(heap, total)
        
        return cost