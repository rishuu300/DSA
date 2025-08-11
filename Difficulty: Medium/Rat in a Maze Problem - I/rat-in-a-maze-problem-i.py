class Solution:
    def solve(self, maze, visited, ans, row, col, move, n):
        if row == n-1 and col == n-1:
            ans.append(move)
            return
        
        drow = [1, 0, 0, -1]
        dcol = [0, -1, 1, 0]
        moves = "DLRU"
        
        for i in range(4):
            adj_row = row + drow[i]
            adj_col = col + dcol[i]
            
            if 0 <= adj_row < n and 0 <= adj_col < n and visited[adj_row][adj_col] == 0 and maze[adj_row][adj_col] == 1:
                
                visited[adj_row][adj_col] = 1
                self.solve(maze, visited, ans, adj_row, adj_col, move+moves[i], n)
                visited[adj_row][adj_col] = 0
    
    def ratInMaze(self, maze):
        ans = []
        n = len(maze)
        visited = [[0 for _ in range(n)] for _ in range(n)]
        
        if maze[0][0] == 1:
            visited[0][0] = 1
            self.solve(maze, visited, ans, 0, 0, "", n)
        
        return ans