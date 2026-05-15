class Solution:
    def solve(self, adj, node, visited, result):
        visited[node] = True
        result.append(node)
        
        for neighbour in adj[node]:
            if not visited[neighbour]:
                self.solve(adj, neighbour, visited, result)
    
    def dfs(self, adj):
        V = len(adj)
        result = []
        visited = [False] * V
        
        self.solve(adj, 0, visited, result)
        
        return result