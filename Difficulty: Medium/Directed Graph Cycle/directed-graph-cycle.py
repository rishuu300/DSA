from collections import defaultdict, deque

class Solution:
    def dfs(self, graph, node, visited, path):
        visited[node] = True
        path[node] = True
        
        for neighbour in graph[node]:
            if not visited[neighbour]:
                if self.dfs(graph, neighbour, visited, path):
                    return True
            
            elif path[neighbour]:
                return True
        
        path[node] = False
        
        return False
    
    def isCyclic(self, V, edges):
        graph = defaultdict(list)
        
        for u, v in edges:
            graph[u].append(v)
        
        visited = [False] * V
        path = [False] * V
        
        for i in range(V):
            if not visited[i]:
                if self.dfs(graph, i, visited, path):
                    return True
        
        return False