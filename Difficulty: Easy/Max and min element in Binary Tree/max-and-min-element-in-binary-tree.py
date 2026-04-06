'''
class Node:
    def __init__(self,val):
        self.data=val
        self.left=None
        self.right=None
'''
class Solution:
    def findMax(self, root):
        if root is None:
            return float('-inf')
        
        left = self.findMax(root.left)
        right = self.findMax(root.right)
        
        return max(root.data, left, right)
    
    def findMin(self, root):
        if root is None:
            return float('inf')
        
        left = self.findMin(root.left)
        right = self.findMin(root.right)
        
        return min(root.data, left, right)