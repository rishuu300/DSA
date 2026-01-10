class Solution:
    def nonRepeatingChar(self,s):
        mp = {}
        
        for char in s:
            mp[char] = mp.get(char, 0) + 1
        
        for char in s:
            if mp[char] == 1:
                return char
        
        return '$'