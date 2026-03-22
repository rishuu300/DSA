class Solution:
    def areAnagrams(self, s1, s2):
        if len(s1) != len(s2):
            return False
        
        count = [0]*256
        
        for i in range(len(s1)):
            count[ord(s1[i])] += 1
        
        for i in range(len(s2)):
            count[ord(s2[i])] -= 1
        
        for i in range(256):
            if count[i] != 0:
                return False
        
        return True