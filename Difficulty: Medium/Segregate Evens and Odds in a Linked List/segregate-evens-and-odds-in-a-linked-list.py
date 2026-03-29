# User function Template for Python3

# Following is the structure of node 
# class node:
#     def __init__(self):  
#         self.data = None
#         self.next = None

class Solution:
    def divide(self, head):
        curr = head
        oddStart, oddEnd = None, None
        evenStart, evenEnd = None, None
        
        while curr:
            data = curr.data
            
            if data%2 != 0:
                if oddStart is None:
                    oddStart = curr
                    oddEnd = curr
                else:
                    oddEnd.next = curr
                    oddEnd = oddEnd.next
            else:
                if evenStart is None:
                    evenStart = curr
                    evenEnd = curr
                else:
                    evenEnd.next = curr
                    evenEnd = evenEnd.next
            
            curr = curr.next
        
        if oddStart is None or evenStart is None:
            return head
        
        evenEnd.next = oddStart
        oddEnd.next = None
        
        return evenStart