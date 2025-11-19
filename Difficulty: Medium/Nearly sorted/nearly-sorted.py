class Solution:
    def nearlySorted(self, arr, k):  
        n = len(arr)
        pq = []
        
        for i in range(k):
            heapq.heappush(pq, arr[i])
        
        i = k
        
        while i < n:
            heapq.heappush(pq, arr[i])
            arr[i-k] = heapq.heappop(pq)
            i += 1
        
        while pq:
            arr[i-k] = heapq.heappop(pq)
            i += 1