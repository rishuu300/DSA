'''
class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None
'''

class Solution:
    def traversal(self, root, result):
        if root is None:
            return
        
        self.traversal(root.left, result)
        self.traversal(root.right, result)
        result.append(root.data)
    
    def postOrder(self, root):
        result = []
        self.traversal(root, result)
        
        return result