# User function Template for python3

class Solution:
    def isSafe(self, graph, colors, node, col):
        for neighbour in graph[node]:
            if colors[neighbour] == col:
                return False
        
        return True
    
    def solve(self, graph, colors, m, node, n):
        if node == n:
            return True
        
        for i in range(1, m+1):
            if self.isSafe(graph, colors, node, i):
                
                colors[node] = i
                
                if self.solve(graph, colors, m, node+1, n):
                    return True
                    
                colors[node] = 0
        return False
    
    def graphColoring(self, n, edges, m):
        graph = [[] for _ in range(n)]
        colors = [0]*n
        
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        return self.solve(graph, colors, m, 0, n)