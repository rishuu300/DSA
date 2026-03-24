class Solution:
    def getLPSLength(self, s):
        n = len(s)
        lps = [0] * n
        index, length = 1, 0
        
        while index < n:
            if s[index] == s[length]:
                lps[index] = length + 1
                
                index += 1
                length += 1
            else:
                if length == 0:
                    lps[index] = 0
                    index += 1
                else:
                    length = lps[length-1]
        
        return lps[n-1]