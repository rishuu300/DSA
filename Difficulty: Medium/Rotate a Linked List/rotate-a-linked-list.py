'''
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
'''

class Solution:
    def rotate(self, head, k):
        if k == 0:
            return head
        
        curr = head
        
        while curr.next:
            curr = curr.next
        
        curr.next = head
        
        curr = head
        
        for _ in range(k-1):
            curr = curr.next
        
        next = curr.next
        curr.next = None
        head = next
        
        return head