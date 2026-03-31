'''
		# Node Class
		class Node:
		    def __init__(self, data):   # data -> value stored in node
		        self.data = data
		        self.next = None
	
'''
class Solution:
    #Function to remove duplicates from unsorted linked list.
    def removeDuplicates(self, head):
        seen = set()
        curr = head
        prev = None
        
        while curr:
            if curr.data in seen:
                prev.next = curr.next
            else:
                prev = curr
                seen.add(curr.data)
            
            curr = curr.next
        
        return head