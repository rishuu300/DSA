class Solution:
    def delete(self, stack, n, curr):
        if not stack:
            return
        
        
        num = stack.pop()
        
        self.delete(stack, n, curr + 1)
        
        
        if curr != n//2:
            stack.append(num)
    
    def deleteMid(self, stack):
        self.delete(stack, len(stack), 0)