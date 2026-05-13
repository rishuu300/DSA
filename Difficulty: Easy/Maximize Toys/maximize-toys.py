#User function Template for python3

import heapq

class Solution:
    def toyCount(self, N, K, arr):
        heap = []
        
        for num in arr:
            heapq.heappush(heap, num)
        
        total = K
        count = 0
        
        while heap and total:
            if total - heap[0] >= 0:
                total -= heapq.heappop(heap)
                count += 1
            else:
                break
        
        return count