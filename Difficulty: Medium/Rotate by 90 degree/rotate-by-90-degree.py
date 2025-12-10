class Solution:
    def rotateMatrix(self, mat):
        n = len(mat)
        
        for i in range(n):
            for j in range(i+1, n):
                mat[i][j], mat[j][i] = mat[j][i], mat[i][j]
        
        for i in range(n):
            u = 0
            d = n-1
            
            while u < d:
                mat[u][i], mat[d][i] = mat[d][i], mat[u][i]
                u += 1
                d -= 1