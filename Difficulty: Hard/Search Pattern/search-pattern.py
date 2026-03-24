class Solution:
    def lps(self, s):
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
        
        return lps
    
    def search(self, pat, txt):
        n = len(txt)
        m = len(pat)
        lps = self.lps(pat)
        
        i, j = 0, 0
        res = []
        
        while i < n:
            if txt[i] == pat[j]:
                i += 1
                j += 1
            
            if j == m:
                res.append(i-j)
                j = lps[j-1]
            elif i < n and txt[i] != pat[j]:
                if j == 0:
                    i += 1
                else:
                    j = lps[j-1]
        
        return res