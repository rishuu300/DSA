from collections import deque


class myStack:

    def __init__(self):
        self.q = deque()


    def push(self, x):
        length = len(self.q)
        self.q.append(x)
        
        for i in range(length):
            data = self.q.popleft()
            self.q.append(data)


    def pop(self):
        if not self.q:
            return None
        return self.q.popleft()


    def top(self):
        if not self.q:
            return -1
        return self.q[0]


    def size(self):
        return len(self.q)