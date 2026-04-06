'''
# Node Class:
class Node:
    def _init_(self, val):
        self.data = val
        self.left = None
        self.right = None
'''

class Solution:
    def height(self, root):
        if root is None:
            return -1
        
        return 1 + max(self.height(root.left), self.height(root.right))