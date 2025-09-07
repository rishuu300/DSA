class Solution:
    def maxOccured(self, L, R):
        n = len(R)
        max_val = max(R)
        freq = [0] * (max_val + 2)
        
        for i in range(n):
            freq[L[i]] += 1
            freq[R[i] + 1] -= 1
        
        max_freq = freq[0]
        ans = 0
        for i in range(1, max_val + 1):
            freq[i] += freq[i - 1]
            
            if freq[i] > max_freq:
                max_freq = freq[i]
                ans = i
        
        return ans