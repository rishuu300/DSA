class Solution:
    def swapBits(self,n):
        oddMask = 0x55555555
        evenMask = 0xAAAAAAAA
        
        oddBits = n & oddMask
        evenBits = n & evenMask
        
        oddBits = oddBits << 1
        evenBits = evenBits >> 1
        
        return oddBits | evenBits