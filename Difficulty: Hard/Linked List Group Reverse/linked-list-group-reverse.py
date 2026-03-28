"""
class Node:
    def __init__(self, data):
		self.data = data
		self.next = None
"""

class Solution:
    def reverseKGroup(self, head, k):
        curr = head
        firstPrev = None
        isFirst = True
        
        while curr:
            first = curr
            prev = None
            count = 0
            
            while curr and count < k:
                next = curr.next
                curr.next = prev
                prev = curr
                curr = next
                count += 1
            
            if isFirst:
                isFirst = False
                head = prev
            else:
                firstPrev.next = prev
            
            firstPrev = first
        
        return head