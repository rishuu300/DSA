# Node class
''' class Node:

    def __init__(self, new_data):
        self.data = new_data
        self.next = None 
'''

# Stack class template
class myStack:
    def __init__(self):
        self.head = None
        self.length = 0
    

    def isEmpty(self):
        return self.head is None
    

    def push(self, x):
        temp = Node(x)
        temp.next = self.head
        self.head = temp
        self.length += 1
    

    def pop(self):
        if self.head is None:
            return None
        
        data = self.head.data
        self.head = self.head.next
        self.length -= 1
        return data
    
    
    def peek(self):
        if self.head is None:
            return -1
        
        return self.head.data


    def size(self):
        return self.length