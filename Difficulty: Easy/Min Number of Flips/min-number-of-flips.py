class Solution:
    def minFlips(self, s):
        flips = 0
        
        for i in range(len(s)):
            if i%2 == 0 and s[i] == '1':
                flips += 1
            elif i%2 == 1 and s[i] == '0':
                flips += 1
        
        return min(flips, len(s)-flips)