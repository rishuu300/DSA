class Solution:
    def calculateSpan(self, prices):
        n = len(prices)
        spans = [0] * n
        stack = []
        
        stack.append(0)
        spans[0] = 1
        
        for i in range(n):
            while stack and prices[i] >= prices[stack[-1]]:
                stack.pop()
            
            span = i + 1 if not stack else i - stack[-1]
            spans[i] = span
            stack.append(i)
        
        return spans