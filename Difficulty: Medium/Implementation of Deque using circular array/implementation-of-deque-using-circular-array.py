class myDeque:
    def __init__(self, n):
        self.cap = n
        self.front = -1
        self.rear = -1
        self.size = 0
        self.arr = [0] * n
    
    def isFull(self):
        return (self.front == (self.rear + 1) % self.cap)

    def isEmpty(self):
        return self.front == -1
    
    def getSize(self):
        return self.size
    
    def insertFront(self, data):
        if self.isFull():
            return
        
        if self.isEmpty():
            self.front = self.rear = 0
        elif self.front == 0:
            self.front = self.cap - 1
        else:
            self.front -= 1
        
        self.arr[self.front] = data
        self.size += 1
    
    def insertRear(self, data):
        if self.isFull():
            return
        
        if self.isEmpty():
            self.front = self.rear = 0
        elif self.rear == self.cap - 1:
            self.rear = 0
        else:
            self.rear += 1
        
        self.arr[self.rear] = data
        self.size += 1
    
    
    def deleteFront(self):
        if self.isEmpty():
            return -1
        
        data = self.arr[self.front]
        
        if self.front == self.rear:
            self.front = self.rear = -1
        elif self.front == self.cap - 1:
            self.front = 0
        else:
            self.front += 1
        
        self.size -= 1
        return data


    def deleteRear(self):
        if self.isEmpty():
            return -1
        
        data = self.arr[self.rear]
        
        if self.front == self.rear:
            self.front = self.rear = -1
        elif self.rear == 0:
            self.rear = self.cap - 1
        else:
            self.rear -= 1
        
        self.size -= 1
        return data


    def frontEle(self):
        if self.isEmpty():
            return -1
        return self.arr[self.front]
    
    def rearEle(self):
        if self.isEmpty():
            return -1
        return self.arr[self.rear]