#Function to check if two numbers in the array have sum equal to the given sum.
def sumExists(arr, N, sum):
    s = set()
    
    for element in arr:
        if sum - element in s:
            return 1
        
        s.add(element)
    
    return 0