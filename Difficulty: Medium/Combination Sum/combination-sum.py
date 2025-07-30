#User function Template for python3

class Solution:
    def solve(self, arr, target, res, curr_list, index):
        if index == len(arr):
            if target == 0:
                res.append(curr_list.copy())
            return
        
        
        if arr[index] <= target:
            curr_list.append(arr[index])
            self.solve(arr, target-arr[index], res, curr_list, index)
            curr_list.pop()
        
        self.solve(arr, target, res, curr_list, index+1)
    
    def combinationSum(self, arr, target):
        res = []
        self.solve(arr, target, res, [], 0)
        return res