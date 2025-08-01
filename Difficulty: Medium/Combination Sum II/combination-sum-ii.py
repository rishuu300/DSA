#User function Template for python3

class Solution:
    def solve(self, arr, target, index, res, curr_list):
        if target == 0:
            res.append(curr_list.copy())
            return
        
        for i in range(index, len(arr)):
            if i > index and arr[i] == arr[i-1]:
                continue
            
            if arr[i] > target:
                break
            
            curr_list.append(arr[i])
            self.solve(arr, target-arr[i], i+1, res, curr_list)
            curr_list.pop()
    
    def uniqueCombinations(self, arr, target):
        arr.sort()
        res = []
        self.solve(arr, target, 0, res, [])
        return res