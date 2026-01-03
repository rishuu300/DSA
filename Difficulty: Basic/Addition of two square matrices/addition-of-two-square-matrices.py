class Solution:
    def Addition(self, matrixA, matrixB):
        n = len(matrixA)
        
        for i in range(n):
            for j in range(n):
                matrixA[i][j] = matrixA[i][j] + matrixB[i][j]
        
        return matrixA