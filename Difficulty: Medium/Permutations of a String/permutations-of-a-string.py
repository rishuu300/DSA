#User function Template for python3

from typing import List

class Solution:
    def swap(self, s: List[str], i: int, j: int):
        s[i], s[j] = s[j], s[i]
    
    
    def permutations(self, s: List[str], res: List[str], l: int, n: int):
        if l==n:
            res.append(''.join(s))
            return
        
        seen = set()
        
        for i in range(l, n):
            if s[i] not in seen:
                seen.add(s[i])
                self.swap(s, i, l)
                self.permutations(s, res, l+1, n)
                self.swap(s, i, l)
    
    def findPermutation(self, s):
        res = []
        s_list = list(s)
        self.permutations(s_list, res, 0, len(s))
        res.sort()
        return res