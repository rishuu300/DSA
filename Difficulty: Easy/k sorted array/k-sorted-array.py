#User function Template for python3

class Solution:
    def isKSortedArray(self, arr, n, k):
        mp = {}
        
        for i in range(n):
            mp[arr[i]] = i
        
        arr.sort()
        
        for i in range(n):
            if abs(mp[arr[i]] - i) > k:
                return 'No'
        
        return 'Yes'