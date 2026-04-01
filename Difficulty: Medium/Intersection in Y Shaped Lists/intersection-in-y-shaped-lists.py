'''
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

'''

class Solution:
    def intersectPoint(self, head1, head2):
        length1 = 1
        curr = head1
        
        while curr:
            length1 += 1
            curr = curr.next
        
        length2 = 1
        curr = head2
        
        while curr:
            length2 += 1
            curr = curr.next
        
        diff = abs(length1 - length2)
        curr1, curr2 = head1, head2
        
        if length1 > length2:
            for _ in range(diff):
                curr1 = curr1.next
        else:
            for _ in range(diff):
                curr2 = curr2.next
        
        while curr1 and curr2:
            if curr1 == curr2:
                return curr1
            
            curr1 = curr1.next
            curr2 = curr2.next
        
        return -1