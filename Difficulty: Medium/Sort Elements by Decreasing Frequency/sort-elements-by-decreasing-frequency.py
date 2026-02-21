#User function Template for python3
 
class Solution:
    def sortByFreq(self, arr):
        freq = {}
        
        for num in arr:
            freq[num] = freq.get(num, 0) + 1
        
        return sorted(arr, key=lambda x: (-freq[x], x))