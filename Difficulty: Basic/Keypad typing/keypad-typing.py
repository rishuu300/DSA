#User function Template for python3


#Function to find matching decimal representation of a string as on the keypad.
def printNumber(s,n):
    res = ''
    
    for char in s:
        
        if char.upper() in 'ABC':
            res += '2'
        
        elif char.upper() in 'DEF':
            res += '3'
        
        elif char.upper() in 'GHI':
            res += '4'
        
        elif char.upper() in 'JKL':
            res += '5'
        
        elif char.upper() in 'MNO':
            res += '6'
        
        elif char.upper() in 'PQRS':
            res += '7'
        
        elif char.upper() in 'TUV':
            res += '8'
        
        elif char.upper() in 'WXYZ':
            res += '9'
    
    return res