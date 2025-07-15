#User function Template for python3

class Solution:
    def minRemoval(self, intervals):
        intervals.sort(key = lambda x : x[1])
        
        res = 0
        prevEnd = intervals[0][1]
        
        for i in range(1, len(intervals)):
            if prevEnd > intervals[i][0]:
                res += 1
            else:
                prevEnd = intervals[i][1]
                
        return res