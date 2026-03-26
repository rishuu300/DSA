class Solution:
    def binarySubstring(self, s):
        count  = 0
        
        for char in s:
            if char == '1':
                count +=1 
        
        return (count*(count-1))//2