class Solution:
    def countDistinct(self, arr, k):
        freq = {}
        res = []
        
        for i in range(k):
            freq[arr[i]] = freq.get(arr[i], 0) + 1
        
        res.append(len(freq))
        
        for i in range(k, len(arr)):
            freq[arr[i - k]] -= 1
            
            if freq[arr[i - k]] == 0:
                del freq[arr[i - k]]
            
            freq[arr[i]] = freq.get(arr[i], 0) + 1
            
            res.append(len(freq))
        
        return res