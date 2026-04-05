class myQueue:
    def __init__(self, n):
        self.capacity = n
        self.queue = [0] * n
        self.front = 0
        self.size = 0

    
    def isEmpty(self):
        return self.size == 0


    def isFull(self):
        return self.size == self.capacity


    def enqueue(self, x):
        rear = (self.front + self.size - 1) % self.capacity
        rear = (rear + 1) % self.capacity
        self.queue[rear] = x
        self.size += 1


    def dequeue(self):
        if self.size == 0:
            return -1
        
        data = self.queue[self.front]
        self.front = (self.front + 1) % self.capacity
        self.size -= 1
        
        return data


    def getFront(self):
        if self.size == 0:
            return -1
        
        return self.queue[self.front]


    def getRear(self):
        if self.size == 0:
            return -1
        
        rear = (self.front + self.size - 1) % 1000
        
        return self.queue[rear]