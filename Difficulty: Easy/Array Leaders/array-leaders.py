class Solution:
    def leaders(self, arr):
        n = len(arr)
        leaders = []
        maxi = arr[n-1]
        leaders.append(maxi)
        
        for i in range(n-2, -1, -1):
            if arr[i] >= maxi:
                leaders.append(arr[i])
                maxi = arr[i]
        
        return leaders[::-1]