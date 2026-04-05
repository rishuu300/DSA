class Solution:
    def reverseQueue(self, q):
        if not q:
            return
        
        front = q.popleft()
        
        self.reverseQueue(q)
        
        q.append(front)