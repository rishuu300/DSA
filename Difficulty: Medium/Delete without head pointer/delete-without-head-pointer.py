'''
    Your task is to delete the given node from
	the linked list, without using head pointer.
	
	Function Arguments: node (given node to be deleted) 
	Return Type: None, just delete the given node from the linked list.

	{
		# Node Class
		class Node:
		    def __init__(self, data):   # data -> value stored in node
		        self.data = data
		        self.next = None
	}
'''
class Solution:
    def deleteNode(self, del_node):
        curr = del_node
        
        while curr.next.next:
            temp = curr.data
            curr.data = curr.next.data
            curr.next.data = temp
            curr = curr.next
        
        curr.data = curr.next.data
        curr.next = None