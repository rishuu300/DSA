class Solution:
    def minWindow(self, s, p):
        n, m = len(s), len(p)
        
        if m > n:
            return ""
        
        Pmap = {}
        for ch in p:
            Pmap[ch] = Pmap.get(ch, 0) + 1
        
        Smap = {}
        left = 0
        curr_length = 0
        total_length = len(Pmap)
        
        start = 0
        result_length = float('inf')
        
        for right in range(n):
            ch = s[right]
            Smap[ch] = Smap.get(ch, 0) + 1
            
            if ch in Pmap and Smap[ch] == Pmap[ch]:
                curr_length += 1
            
            while curr_length == total_length:
                if right - left + 1 < result_length:
                    result_length = right - left + 1
                    start = left
                
                left_char = s[left]
                Smap[left_char] -= 1
                
                if left_char in Pmap and Smap[left_char] < Pmap[left_char]:
                    curr_length -= 1
                
                left += 1
            
        return "" if result_length == float('inf') else s[start : start + result_length]