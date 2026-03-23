class Solution:
    def fact(self, n):
        if n <= 1:
            return 1
        return n * self.fact(n - 1)
    
    def findRank(self, S):
        n = len(S)
        count = [0] * 26
        
        for i in range(n):
            count[ord(S[i]) - ord('a')] += 1
        
        for i in range(1, 26):
            count[i] += count[i-1]
        
        mul = self.fact(n)
        rank = 1
        
        for i in range(n):
            mul //= (n - i)
            char_index = ord(S[i]) - ord('a')
            
            if char_index > 0:
                rank += count[char_index - 1] * mul
            
            for j in range(char_index, 26):
                count[j] -= 1
        
        return rank