'''
class Node:
    def __init__(self, x):
        self.data = x
        self.next = None
'''
class Solution:
    def swapKth(self, head, k):
        length = 0
        temp = head
        while temp:
            length += 1
            temp = temp.next
        
        if k > length:
            return head
        
        fast = head
        prevX = None
        for _ in range(k - 1):
            prevX = fast
            fast = fast.next
        
        X = fast
        
        slow = head
        prevY = None
        while fast.next:
            prevY = slow
            slow = slow.next
            fast = fast.next
        
        Y = slow
        
        if prevX:
            prevX.next = Y
        if prevY:
            prevY.next = X
        
        X.next, Y.next = Y.next, X.next
        
        if k == 1:
            head = Y
        if k == length:
            head = X
        
        return head