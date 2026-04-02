class Solution:
    def isRightAssociative(self, char):
        return char == '^'
        
    
    def precedence(self, char):
        if char == '^':
            return 3
        elif char == '/' or char == '*':
            return 2
        elif char == '+' or char == '-':
            return 1
        else:
            return -1
    
    def infixtoPostfix(self, s):
        stack = []
        res = []
        
        for char in s:
            if 'a' <= char <= 'z' or 'A' <= char <= 'Z' or '0' <= char <= '9':
                res.append(char)
            
            elif char == '(':
                stack.append(char)
            
            elif char == ')':
                while stack and stack[-1] != '(':
                    res.append(stack.pop())
                stack.pop()
            
            else:
                while (stack and
                        (self.precedence(stack[-1]) > self.precedence(char) or
                        (self.precedence(stack[-1]) == self.precedence(char) and not self.isRightAssociative(char)))):
                            res.append(stack.pop())
                
                stack.append(char)
        
        while stack:
            res.append(stack.pop())
        
        return ''.join(res)
        
        
        