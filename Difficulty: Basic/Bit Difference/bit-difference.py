class Solution:
    def countBitsFlip(self, a, b):
        XOR = a^b
        count = 0
        
        while XOR > 0:
            if XOR&1 == 1:
                count += 1
            
            XOR = XOR >> 1
        
        return count