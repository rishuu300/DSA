'''
class Node:
    def __init__(self, data): 
        self.data = data
        self.next = None
'''

class Solution:
    def lengthOfLoop(self, head):
        slow = head
        fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
            if slow == fast:
                length = 1
                temp = slow.next
                
                while temp != slow:
                    length += 1
                    temp = temp.next
                
                return length
        
        return 0