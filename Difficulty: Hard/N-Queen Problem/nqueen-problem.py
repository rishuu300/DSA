#User function Template for python3

class Solution:
    def nQueen(self, n):
        res = []
        board = []
        leftRow = [False] * n
        lowerDiagonal = [False] * (2 * n - 1)
        upperDiagonal = [False] * (2 * n - 1)
        self.solve(0, res, board, leftRow, lowerDiagonal, upperDiagonal, n)
        return res
    
    def solve(self, col, res, board, leftRow, lowerDiagonal, upperDiagonal, n):
        if col == n:
            res.append(board.copy())
            return
        
        for row in range(n):
            if not leftRow[row] and not lowerDiagonal[row+col] and not upperDiagonal[(n-1) + (col-row)]:
                
                board.append(row+1)
                leftRow[row] = True
                lowerDiagonal[row+col] = True
                upperDiagonal[(n-1) + (col-row)] = True
                
                self.solve(col+1, res, board, leftRow, lowerDiagonal, upperDiagonal, n)
                
                board.pop()
                leftRow[row] = False
                lowerDiagonal[row+col] = False
                upperDiagonal[(n-1) + (col-row)] = False