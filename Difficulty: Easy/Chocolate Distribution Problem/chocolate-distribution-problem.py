#User function Template for python3

class Solution:
    def findMinDiff(self, arr, M):
        arr.sort()
        res = 1e9
        
        for i in range(len(arr)-M+1):
            res = min(res, arr[i+M-1] - arr[i])
        
        return res