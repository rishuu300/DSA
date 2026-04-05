min_stack = []

def _push(arr, n):
    stack = []
    
    for i in range(n):
        stack.append(arr[i])
        
        if not min_stack or arr[i] <= min_stack[-1]:
            min_stack.append(arr[i])
    
    return stack

def _getMinAtPop(stack):
    while stack:
        print(min_stack[-1], end=" ")
        
        top = stack.pop()
        
        if top == min_stack[-1]:
            min_stack.pop()