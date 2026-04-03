class TwoStacks:
    def __init__(self):
        self.stack = [0] * 100
        self.top1 = -1
        self.top2 = 100

    def push1(self, x):
        if self.top1 < self.top2 - 1:
            self.top1 += 1
            self.stack[self.top1] = x


    def push2(self, x):
        if self.top1 < self.top2 - 1:
            self.top2 -= 1
            self.stack[self.top2] = x


    def pop1(self):
        if self.top1 >= 0:
            data = self.stack[self.top1]
            self.top1 -= 1
            return data
        
        return -1


    def pop2(self):
        if self.top2 < 100:
            data = self.stack[self.top2]
            self.top2 += 1
            return data
        
        return -1