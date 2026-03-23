class Solution:
    def isPanagram(self, s):
        count = [0] * 26
        
        for char in s:
            if 'a' <= char <= 'z':
                count[ord(char) - ord('a')] += 1
            
            if 'A' <= char <= 'Z':
                count[ord(char) - ord('A')] += 1
        
        for i in range(26):
            if count[i] == 0:
                return False
        
        return  True