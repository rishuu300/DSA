class Solution:
    def fractionalknapsack(self, val, wt, capacity):
        n = len(val)
        
        items = [(val[i], wt[i], val[i]/wt[i]) for i in range(n)]
        
        items.sort(key = lambda x : x[2], reverse = True)
        
        total_value = 0.0
        
        for value, weight, ratio in items:
            if capacity >= weight:
                total_value += value
                capacity -= weight
            else:
                total_value += ratio * capacity
                break
        
        return total_value