from collections import deque

class Solution:
    def bfs(self, adj):
        V = len(adj)
        q = deque()
        result = []
        visited = [False] * V
        
        q.append(0)
        visited[0] = True
        
        while q:
            node = q.popleft()
            result.append(node)
            
            for neighbour in adj[node]:
                if not visited[neighbour]:
                    q.append(neighbour)
                    visited[neighbour] = True
        
        return result