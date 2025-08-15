from typing import List


class Solution:
    def kthPermutation(self, n : int, k : int) -> str:
        fact = 1
        numbers = []
        
        for i in range(1, n):
            fact *= i
            numbers.append(i)
        
        numbers.append(n)
        k -= 1
        
        ans = ""
        while(True):
            ans += str(numbers[k//fact])
            numbers.pop(k//fact)
            
            if not numbers:
                break
            
            k %= fact
            fact //= len(numbers)
        
        return ans