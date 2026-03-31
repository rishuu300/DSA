'''
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
'''

class Solution:
    def reverse(self, head):
        curr = head
        prev = None
        
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        
        return prev
    
    def addTwoLists(self, head1, head2):
        head1 = self.reverse(head1)
        head2 = self.reverse(head2)
        
        add = None
        carry = 0
        
        while head1 or head2 or carry:
            newVal = carry
            
            newVal += head1.data if head1 else 0
            newVal += head2.data if head2 else 0
            
            carry = newVal // 10
            newVal = newVal % 10
            
            newNode = Node(newVal)
            
            newNode.next = add
            add = newNode
            
            head1 = head1.next if head1 else None
            head2 = head2.next if head2 else None
        
        while add and add.data == 0:
            temp = add.next
            add.next = None
            add = temp
        
        return Node(0) if add == None else add