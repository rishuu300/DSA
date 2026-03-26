class Solution:
    def areIsomorphic(self, s1, s2):
        mapping = {}
        
        for ch1, ch2 in zip(s1, s2):
            if ch1 not in mapping:
                if ch2 not in mapping.values():
                    mapping[ch1] = ch2
                else:
                    return False
            else:
                if mapping[ch1] != ch2:
                    return False
        
        return True