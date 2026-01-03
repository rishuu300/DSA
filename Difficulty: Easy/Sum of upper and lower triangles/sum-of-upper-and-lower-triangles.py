class Solution:
    def sumTriangles(self,mat):
        n = len(mat)
        upper_sum, lower_sum = 0, 0
        
        for i in range(n):
            for j in range(i,n):
                if i == j:
                    upper_sum += mat[i][j]
                    lower_sum += mat[i][j]
                else:
                    upper_sum += mat[i][j]
                    lower_sum += mat[j][i]
        
        return [upper_sum, lower_sum]