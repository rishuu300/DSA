from collections import defaultdict, deque

class Solution:
    def topoSort(self, V, edges):
        graph = defaultdict(list)
        indegree = [0] * V
        
        for u, v in edges:
            graph[u].append(v)
            indegree[v] += 1
        
        q = deque()
        
        for i in range(V):
            if indegree[i] == 0:
                q.append(i)
        
        result = []
        
        while q:
            node = q.popleft()
            result.append(node)
            
            for neighbour in graph[node]:
                indegree[neighbour] -= 1
                
                if indegree[neighbour] == 0:
                    q.append(neighbour)
        
        return result