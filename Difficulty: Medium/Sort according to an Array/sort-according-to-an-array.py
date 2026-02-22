class Solution:
    def relativeSort(self, a1, a2):
        m, n = len(a1), len(a2)
        freq = {}
        
        for num in a1:
            freq[num] = freq.get(num, 0) + 1
        
        index = 0
        
        for num in a2:
            while freq.get(num, 0) > 0:
                a1[index] = num
                index += 1
                freq[num] -= 1
                
            freq.pop(num, None)
        
        remaining = []
        
        for key in freq:
            remaining.extend([key] * freq[key])
        
        remaining.sort()
        
        for num in remaining:
            a1[index] = num
            index += 1