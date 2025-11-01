class Solution:
    def intersection(self, arr1, arr2):
        s = set()
        
        for element in arr1:
            s.add(element)
        
        ans = []
        
        for element in arr2:
            if element in s:
                ans.append(element)
                s.remove(element)
        
        return ans