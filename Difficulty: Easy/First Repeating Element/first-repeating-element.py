class Solution:
    def firstRepeated(self,arr):
        mp = {}
        res = 1e6
        
        for i in range(len(arr)):
            if arr[i] not in mp:
                mp[arr[i]] = i
            else:
                res = min(res, mp[arr[i]])
        
        return -1 if res == 1e6 else res+1