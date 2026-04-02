class Solution:
    def isOperand(self, char):
        return char.lstrip('-').isdigit()
    
    def evaluatePostfix(self, arr):
        stack = []
        # chars = arr.split()
        
        for char in arr:
            if self.isOperand(char):
                stack.append(int(char))
            else:
                op1 = stack.pop()
                op2 = stack.pop()
                
                if char == '^':
                    stack.append(int(math.pow(op2, op1)))
                
                elif char == '/':
                    stack.append(op2 // op1)
                
                elif char == '*':
                    stack.append(op2 * op1)
                
                elif char == '+':
                    stack.append(op2 + op1)
                
                else:
                    stack.append(op2 - op1)
            
        return stack[-1]