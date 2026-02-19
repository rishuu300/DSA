class Solution:
    def subArraySum(self,arr, tar):
        freq = {}
        count = 0
        prefix_sum = 0
        
        for num in arr:
            prefix_sum += num
            
            if prefix_sum == tar:
                count += 1
            
            if prefix_sum - tar in freq:
                count += freq[prefix_sum - tar]
            
            freq[prefix_sum] = freq.get(prefix_sum, 0) + 1
        
        return count