class Solution:
    def nonRepeatingChar(self,s):
        count = [-1]*26
        
        for i in range(len(s)):
            if count[ord(s[i]) - ord('a')] == -1:
                count[ord(s[i]) - ord('a')] = i
            else:
                count[ord(s[i]) - ord('a')] = -2
        
        res = 1e5
        
        for i in range(26):
            if count[i] >= 0:
                res = min(res, count[i])
        
        return s[res] if res != 1e5 else-1