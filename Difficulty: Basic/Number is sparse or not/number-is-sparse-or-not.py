class Solution:
    def isSparse(self,n):
        return not n&(n>>1) >= 1
