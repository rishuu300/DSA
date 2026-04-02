class Solution:
    def checker(self, char1, char2):
        return (
            (char1 == '{' and char2 == '}') or 
            (char1 == '[' and char2 == ']') or
            (char1 == '(' and char2 == ')')
        )
    
    def isBalanced(self, s):
        stack = []
        
        for char in s:
            if char in '{[(':
                stack.append(char)
            else:
                if not stack:
                    return False
                
                top = stack.pop()
                if not self.checker(top, char):
                    return False
        
        return len(stack) == 0