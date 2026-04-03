class kStacks:
    def __init__(self, n, k):
        self.arr = [0] * n
        self.top = [-1] * k
        self.nxt = [i + 1 for i in range(n)]
        self.nxt[n-1] = -1
        self.freespot = 0

    def push(self, x, i):
        if self.freespot == -1:
            return
        
        index = self.freespot
        self.freespot = self.nxt[index]
        self.nxt[index] = self.top[i-1]
        self.top[i-1] = index
        
        self.arr[index] = x

    def pop(self, i):
        if self.top[i-1] == -1:
            return -1
        
        index = self.top[i-1]
        self.top[i-1] = self.nxt[index]
        self.nxt[index] = self.freespot
        self.freespot = index
        
        return self.arr[index]