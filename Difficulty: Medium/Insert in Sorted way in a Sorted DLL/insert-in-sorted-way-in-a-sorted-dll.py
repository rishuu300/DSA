'''
class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None
'''
class Solution:
    def sortedInsert(self, head, x):
        temp = Node(x)
        
        if head == None:
            return temp
        
        if temp.data <= head.data:
            temp.next = head
            head.prev = temp
            return temp
        
        curr = head
        while curr.next and curr.next.data < x:
            curr = curr.next
        
        if curr.next == None:
            curr.next = temp
            temp.prev = curr
            return head
        
        temp.next = curr.next
        curr.next.prev = temp
        curr.next = temp
        temp.prev = curr
        
        return head