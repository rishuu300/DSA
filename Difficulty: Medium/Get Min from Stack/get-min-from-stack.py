class SpecialStack:
    def __init__(self):
        self.stack = []
        self.mini = float('inf')
    
    
    def push(self, x):
        if not self.stack:
            self.mini = x
            self.stack.append(x)
        
        elif x < self.mini:
            self.stack.append(2 * x - self.mini)
            self.mini = x
        
        else:
            self.stack.append(x)

    
    def pop(self):
        if not self.stack:
            return -1
        
        top = self.stack.pop()
        
        if top < self.mini:
            temp = self.mini
            self.mini = 2 * self.mini - top
            top = temp
        
        return top

    
    def peek(self):
        if not self.stack:
            return -1
        
        top = self.stack[-1]
        
        if top < self.mini:
            return self.mini
        
        return top
    
    
    def isEmpty(self):
        return not self.stack

    
    def getMin(self):
        if not self.stack:
            return -1
        
        return self.mini