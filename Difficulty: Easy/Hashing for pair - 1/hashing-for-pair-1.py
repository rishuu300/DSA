##Complete this function
#Function to check if there is a pair with the given sum in the array.
def sumExists(arr, N, sum):
    s = set()
    
    for element in arr:
        if sum-element in s:
            return 1
        s.add(element)
    
    return 0