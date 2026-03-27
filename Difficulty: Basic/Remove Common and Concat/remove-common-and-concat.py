class Solution:
    def concatenatedString(self, s1, s2):
        mapping = {}
        
        for ch in s2:
            mapping[ch] = 1
        
        result = ""
        for ch in s1:
            if ch not in mapping:
                result += ch
            else:
                mapping[ch] = 2
        
        
        for ch in s2:
            if mapping[ch] == 1:
                result += ch
        
        return result if len(result) > 0 else "-1"