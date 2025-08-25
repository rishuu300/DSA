class Solution:
    def twoOddNum(self, arr):
        XOR = 0
        
        for num in arr:
            XOR ^= num
        
        odd1, odd2 = 0, 0
        bit_diff = XOR & (~(XOR - 1))
        
        for num in arr:
            if num  & bit_diff:
                odd1 ^= num
            else:
                odd2 ^= num
        
        return sorted([odd1, odd2], reverse=True)
