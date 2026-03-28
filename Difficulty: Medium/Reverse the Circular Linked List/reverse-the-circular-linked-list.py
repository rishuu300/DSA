'''
class Node:

    def __init__(self, data):
        self.data = data
        self.next = None
'''
class Solution:
    def reverseCircular(self, head):
        curr = head
        prev = None
        
        while True:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
            
            if curr == head:
                break
        
        head.next = prev
        
        return prev