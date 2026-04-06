"""
class Node:
    def __init__(self, value):
        self.data = value
        self.left = None
        self.right = None
"""

from collections import deque

class Solution:
    def levelOrder(self, root):
        q = deque()
        result = []
        
        q.append(root)
        
        while q:
            size = len(q)
            curr = []
            
            for _ in range(size):
                root = q.popleft()
                curr.append(root.data)
                
                if root.left:
                    q.append(root.left)
                
                if root.right:
                    q.append(root.right)
            
            result.append(curr)
        
        return result