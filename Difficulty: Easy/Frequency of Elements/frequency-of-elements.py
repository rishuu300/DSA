class Solution:
    def countFreq(self, arr):
        mp = {}
        res = []
        
        for num in arr:
            mp[num] = mp.get(num, 0) + 1
        
        for num, count in mp.items():
            res.append([num, count])
        
        return res