class Solution:
    def reverseStack(self, st):
        aux = []
        
        while st:
            aux.append(st.pop())
        
        st[:] = aux