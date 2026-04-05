class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

class myDeque:
    def __init__(self):
        self.front = None
        self.rear = None


    def isEmpty(self):
        return self.front is None


    def insertFront(self, data):
        temp = Node(data)
        
        if self.isEmpty():
            self.front = self.rear = temp
        else:
            temp.next = self.front
            self.front.prev = temp
            self.front = temp


    def insertRear(self, data):
        temp = Node(data)
        
        if self.isEmpty():
            self.front = self.rear = temp
        else:
            self.rear.next = temp
            temp.prev = self.rear
            self.rear = temp


    def deleteFront(self):
        if self.isEmpty():
            return -1
        
        data = self.front.data
        self.front = self.front.next
        
        if self.front is None:
            self.rear = None
        else:
            self.front.prev = None
        
        return data


    def deleteRear(self):
        if self.isEmpty():
            return -1
        
        data = self.rear.data
        self.rear = self.rear.prev
        
        if self.rear is None:
            self.front = None
        else:
            self.rear.next = None
        
        return data


    def getFront(self):
        if self.isEmpty():
            return -1
        return self.front.data


    def getRear(self):
        if self.isEmpty():
            return -1
        return self.rear.data
