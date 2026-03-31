'''
class Node:
    def __init__(self, x):
        self.data = x
        self.next = None
        self.random = None
'''        

class Solution:
    def cloneLinkedList(self, head):
        curr = head
        
        while curr:
            clone = Node(curr.data)
            next = curr.next
            curr.next = clone
            clone.next = next
            curr = next
        
        curr = head
        
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            
            curr = curr.next.next
        
        clone_head = head.next
        curr = head
        
        while curr:
            clone = curr.next
            next = curr.next.next
            curr.next = next
            curr = curr.next
            
            if curr != None:
                clone.next = curr.next
        
        return clone_head