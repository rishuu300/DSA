class Solution:
    def longestUniqueSubstr(self, s):
        n = len(s)
        prev = [-1] * 26
        index, res = 0, 0
        
        for i in range(n):
            index = max(index, prev[ord(s[i]) - ord('a')] + 1)
            maxEnd = i - index + 1
            res = max(res, maxEnd)
            prev[ord(s[i]) - ord('a')] = i
        
        return res