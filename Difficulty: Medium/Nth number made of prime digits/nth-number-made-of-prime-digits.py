from collections import deque

class Solution:
    def primeDigits(self, n):
        q = deque()
        q.append(2)
        q.append(3)
        q.append(5)
        q.append(7)
        
        count, result = 0, 0
        
        while count < n:
            result = q.popleft()
            count += 1
            
            if count == n:
                return result
            
            q.append(result * 10 + 2)
            q.append(result * 10 + 3)
            q.append(result * 10 + 5)
            q.append(result * 10 + 7)
        
        return result