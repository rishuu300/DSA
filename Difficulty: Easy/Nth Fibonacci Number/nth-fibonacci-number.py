
class Solution:
    def nthFibonacci(self, n: int) -> int:
        if n == 0 or n == 1:
            return n
        return self.nthFibonacci(n-1) + self.nthFibonacci(n-2)