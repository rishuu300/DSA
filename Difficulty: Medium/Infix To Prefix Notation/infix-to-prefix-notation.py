class Solution:
    def precedence(self, char):
        if char == '^':
            return 3
        elif char == '/' or char == '*':
            return 2
        elif char == '+' or char == '-':
            return 1
        else:
            return -1
    
    def infixToPrefix(self, s):
        stack = []
        res = []
        
        for char in s[::-1]:
            if char.isalnum():
                res.append(char)
            
            elif char == ')':
                stack.append(char)
            
            elif char == '(':
                while stack and stack[-1] != ')':
                    res.append(stack.pop())
                
                stack.pop()
            
            else:
                while (stack and 
                        (self.precedence(stack[-1]) > self.precedence(char) or 
                        (self.precedence(stack[-1]) == self.precedence(char) and char == '^'))):
                    
                    res.append(stack.pop())
                
                stack.append(char)
        
        while stack:
            res.append(stack.pop())
        
        return ''.join(res[::-1])