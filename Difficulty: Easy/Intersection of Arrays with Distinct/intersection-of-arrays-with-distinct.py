class Solution:
    def intersectSize(self,a, b):
        s = set()
        
        for element in b:
            s.add(element)
        
        count = 0
        
        for element in a:
            if element in s:
                count += 1
                s.remove(element)
        
        return count