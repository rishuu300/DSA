class Solution:
    def repeatingCharacter(self, s):
        count = [0]*256
        res = -1
        
        for i in range(len(s)-1, -1, -1):
            if count[ord(s[i])]:
                res = i
            
            count[ord(s[i])] += 1
        
        return res