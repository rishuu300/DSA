class myStack:
    def __init__(self, n):
        self.capacity = n
        self.stack = []

    
    def isEmpty(self):
        return len(self.stack) == 0

    
    def isFull(self):
        return len(self.stack) == self.capacity

    
    def push(self, x):
        if len(self.stack) == self.capacity:
            return
        
        self.stack.append(x)

    
    def pop(self):
        if len(self.stack) == 0:
            return -1
        
        return self.stack.pop()

    
    def peek(self):
        if len(self.stack) == 0:
            return -1
        
        return self.stack[-1]