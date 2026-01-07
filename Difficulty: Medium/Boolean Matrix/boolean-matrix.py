class Solution:
    def booleanMatrix(self, mat):
        n, m = len(mat), len(mat[0])
        row, col = [0]*n, [0]*m
        
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 1:
                    row[i] = 1
                    col[j] = 1
        
        for i in range(n):
            for j in range(m):
                if row[i] == 1 or col[j] == 1:
                    mat[i][j] = 1