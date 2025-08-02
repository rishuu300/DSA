class Solution:
	def subsetSums(self, arr):
		res = []
		self.solve(arr, 0, res, 0)
		return res
	
	def solve(self, arr, index, res, total_sum):
	    if index == len(arr):
	        res.append(total_sum)
	        return
	    
	    self.solve(arr, index+1, res, total_sum)
	    self.solve(arr, index+1, res, total_sum+arr[index])