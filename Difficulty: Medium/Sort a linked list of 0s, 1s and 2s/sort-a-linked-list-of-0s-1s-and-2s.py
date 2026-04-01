'''
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
'''
	
class Solution:
    def segregate(self, head):
        if head is None or head.next is None:
            return head
        
        zeroD = Node(-1)
        oneD = Node(-1)
        twoD = Node(-1)
        
        zero = zeroD
        one = oneD
        two = twoD
        
        curr = head
        
        while curr:
            if curr.data == 0:
                zero.next = curr
                zero = zero.next
            elif curr.data == 1:
                one.next = curr
                one = one.next
            else:
                two.next = curr
                two = two.next
            
            curr = curr.next
        
        zero.next = oneD.next if oneD.next != None else twoD.next
        one.next =  twoD.next
        two.next = None
        
        head = zeroD.next
        
        return head