from collections import deque

class Solution:
    def reverseFirstK(self, q, k):
        n = len(q)
        d = deque()
        
        if k > n:
            return q
        
        for _ in range(k):
            d.append(q.popleft())
        
        for _ in range(k):
            q.append(d.pop())
        
        for _ in range(n - k):
            q.append(q.popleft())
        
        return q