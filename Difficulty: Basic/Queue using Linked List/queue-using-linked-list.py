# Node class
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


# Queue class template
class myQueue:
    def __init__(self):
        self.front = None
        self.rear = None
        self.length = 0


    def isEmpty(self):
        return self.front is None


    def enqueue(self, x):
        new_Node = Node(x)
        
        if not self.front:
            self.front = self.rear = new_Node
        else:
            self.rear.next = new_Node
            self.rear = self.rear.next
        
        self.length += 1

    def dequeue(self):
        if self.isEmpty():
            return -1
        
        data = self.front.data
        self.front = self.front.next
        
        if self.front is None:
            self.rear = None
        
        self.length -= 1
        
        return data


    def getFront(self):
        if self.isEmpty():
            return -1
        
        return self.front.data


    def size(self):
        return self.length
