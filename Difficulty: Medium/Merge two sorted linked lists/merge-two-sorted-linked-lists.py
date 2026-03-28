'''
class Node:
    def __init__(self, data): 
        self.data = data
        self.next = None

'''
class Solution:
    def sortedMerge(self, head1, head2):
        if head1.data > head2.data:
            temp = head1
            head1 = head2
            head2 = temp
        
        res = head1
        
        while head1 != None and head2 != None:
            curr = None
            
            while head1 != None and head1.data <= head2.data:
                curr = head1
                head1 = head1.next
            
            curr.next = head2
            
            temp = head1
            head1 = head2
            head2 = temp
        
        return res