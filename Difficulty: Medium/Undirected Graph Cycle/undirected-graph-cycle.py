from collections import defaultdict, deque

class Solution:
    def bfs(self, graph, start, visited):
        q = deque()
        
        q.append([start, -1])
        visited[start] = True
        
        while q:
            node = q.popleft()
            data = node[0]
            parent = node[1]
            
            for neighbour in graph[data]:
                
                if not visited[neighbour]:
                    q.append([neighbour, data])
                    visited[neighbour] = True
                
                elif parent != neighbour:
                    return True
        
        return False
    
    def isCycle(self, V, edges):
        graph = defaultdict(list)
        
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        visited = [False] * V
        
        for i in range(V):
            if not visited[i]:
                if self.bfs(graph, i, visited):
                    return True
        
        return False