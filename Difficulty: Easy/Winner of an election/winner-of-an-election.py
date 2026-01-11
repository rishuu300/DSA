#User function Template for python3

class Solution:
    def winner(self,arr,n):
        mp = {}
        
        for candidate in arr:
            mp[candidate] = mp.get(candidate, 0) + 1
        
        max_count = 0
        winner = ""
        
        for key, value in mp.items():
            if value > max_count:
                max_count = value
                winner = key
            elif max_count == value and winner > key:
                winner = key
        
        return [winner, max_count]
