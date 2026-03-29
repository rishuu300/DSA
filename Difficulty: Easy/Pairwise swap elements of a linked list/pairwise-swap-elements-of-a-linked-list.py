"""  list Node is as defined below:

class Node:
    def __init__(self, data):
		self.data = data
		self.next = None

"""

# complete this function
# return head of list after swapping
class Solution:
    def pairWiseSwap(self, head):
        curr = head.next.next
        prev = head
        head = head.next
        head.next = prev
        
        while curr and curr.next:
            prev.next = curr.next
            prev = curr
            next = curr.next.next
            curr = curr.next
            curr.next = prev
            curr = next
        
        prev.next = curr
        
        return head