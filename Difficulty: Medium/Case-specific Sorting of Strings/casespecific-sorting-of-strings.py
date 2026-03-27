class Solution:
    def caseSort(self, s):
        UC, LC = [0]*26, [0]*26
        
        for ch in s:
            if 'a' <= ch <= 'z':
                LC[ord(ch) - ord('a')] += 1
            else:
                UC[ord(ch) - ord('A')] += 1
        
        result = ""
        li, ui = 0, 0
        
        for ch in s:
            if 'a' <= ch <= 'z':
                while li < 26 and LC[li] == 0:
                    li += 1
                
                if li < 26:
                    result += chr(li + ord('a'))
                    LC[li] -= 1
            else:
                while ui < 26 and UC[ui] == 0:
                    ui += 1
                
                if ui < 26:
                    result += chr(ui + ord('A'))
                    UC[ui] -= 1
        
        return result