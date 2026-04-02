class Solution:
    def isOperand(self, char):
        return char.lstrip('-').isdigit()
    
    def evaluatePrefix(self, arr):
        stack = []
        res = []
        
        for char in reversed(arr):
            if self.isOperand(char):
                stack.append(int(char))
            else:
                op1 = stack.pop()
                op2 = stack.pop()
                
                if char == '^':
                    stack.append(op1 ** op2)
                
                elif char == '/':
                    stack.append(op1 // op2)
                
                elif char == '*':
                    stack.append(op1 * op2)
                
                elif char == '+':
                    stack.append(op1 + op2)
                
                else:
                    stack.append(op1 - op2)
        
        return stack[-1]