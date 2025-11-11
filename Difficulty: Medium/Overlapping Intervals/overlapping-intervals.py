class Solution:
    def mergeOverlap(self, arr):
        arr.sort(key=lambda x: x[0])
        res = []
        
        curr_interval = arr[0]
        res.append(curr_interval)
        
        for i in range(1, len(arr)):
            next_interval = arr[i]
            
            if curr_interval[1] >= next_interval[0]:
                curr_interval[1] = max(curr_interval[1], next_interval[1])
            else:
                curr_interval = next_interval
                res.append(curr_interval)
            
        return res