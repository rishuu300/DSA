#User function Template for python3
class Solution:
    def search(self, pat, txt):
        n = len(txt)
        m = len(pat)
        count_txt = [0] * 26
        count_pat = [0] * 26
        
        for i in range(m):
            count_txt[ord(txt[i]) - ord('a')] += 1
            count_pat[ord(pat[i]) - ord('a')] += 1
        
        count = 0
        for i in range(m, n):
            if count_txt == count_pat:
                count += 1
            
            count_txt[ord(txt[i]) - ord('a')] += 1
            char_index = ord(txt[i - m]) - ord('a')
            count_txt[char_index] -= 1
        
        if count_txt == count_pat:
            count += 1
        
        return count