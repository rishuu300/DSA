import heapq
from collections import Counter

class Solution :
    def rearrangeString(self, s):
        heap = []
        freq = Counter(s)
        
        for char, count in freq.items():
            heapq.heappush(heap, (-count, char))
        
        result = []
        prev_char, prev_count = "", 0
        
        while heap:
            count, char = heapq.heappop(heap)
            
            result.append(char)
            
            if prev_count < 0:
                heapq.heappush(heap, (prev_count, prev_char))
            
            count += 1
            
            prev_count, prev_char = count, char
        
        result = "".join(result)
        
        return result if len(result) == len(s) else ""