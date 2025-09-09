class Solution:
    def rearrange(self, arr):
        arr.sort()
        n = len(arr)
        
        if n==1:
            return
        
        minInd = 0
        maxInd = n-1
        maxi = arr[n-1] + 1
        
        for i in range(n):
            if i%2==0:
                arr[i] = (arr[maxInd] % maxi) * maxi + arr[i]
                maxInd -=  1
            else:
                arr[i] = (arr[minInd] % maxi) * maxi + arr[i]
                minInd += 1
        
        for i in range(n):
            arr[i] = arr[i] // maxi