from typing import List


class Solution:
    def maximumProfit(self, prices) -> int:
        profit = 0
        
        for i in range(1, len(arr)):
            if arr[i] > arr[i-1]:
                profit += (arr[i] - arr[i-1])
        
        return profit
