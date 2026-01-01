#User function Template for python3
class Solution:
	def matSearch(self, mat, x):
	    n, m = len(mat), len(mat[0])
	    row, col = 0, m-1
	    
	    while row < n and col >= 0:
	        if mat[row][col] == x:
	            return True
	        elif mat[row][col] > x:
	            col -= 1
	        else:
	            row += 1
	    return False