class Solution:
    def palinParts (self, s):
        res = []
        self.solve(s, 0, res, [])
        return res
    
    
    def solve(self, s, start, res,  curr_list):
        if start == len(s):
            res.append(curr_list.copy())
            return
        
        for i in range(start, len(s)):
            if self.isPalindrome(s, start, i):
                curr_list.append(s[start:i+1])
                self.solve(s, i+1, res, curr_list)
                curr_list.pop()
    
    def isPalindrome(self, s, start, end):
        while start <= end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True