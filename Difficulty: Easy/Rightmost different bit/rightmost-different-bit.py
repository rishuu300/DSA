import math

class Solution:
    def posOfRightMostDiffBit(self,m,n):
        if m == n:
            return -1
        
        n = m ^ n
        
        if (n == 0):
            return 0
        
        return math.log2(n & -n) + 1