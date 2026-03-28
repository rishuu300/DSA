#class Node:
#    def __init__(self, data):
#        self.data = data
#        self.next = None


# your task is to complete this function
# function should return true/false or 1/0
class Solution:
    def isCircular(self, head):
        slow = head
        fast = head.next
        
        while fast and fast.next:
            if fast == slow:
                return True
            
            slow = slow.next
            fast = fast.next.next
        
        return False