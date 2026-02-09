class Solution:
    def checkEqual(self, a, b) -> bool:
        mp = {}
        
        for element in a:
            mp[element] = mp.get(element, 0) + 1
        
        for element in b:
            if element not in mp:
                return False
            else:
                mp[element] = mp[element] - 1
            
            if mp[element] == 0:
                del mp[element]
        
        return True