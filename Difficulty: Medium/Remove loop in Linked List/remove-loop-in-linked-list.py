'''
# node class:

class Node:
    def __init__(self,val):
        self.next=None
        self.data=val

'''

class Solution:
    def removeLoop(self, head):
        slow = head
        fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
            if fast == slow:
                break
        
        if slow != fast:
            return
        
        if fast == head and slow == head:
            while fast.next != slow:
                fast = fast.next
            
            fast.next = None
            return
        
        slow = head
        while fast.next != slow.next:
            fast = fast.next
            slow = slow.next
        
        fast.next = None