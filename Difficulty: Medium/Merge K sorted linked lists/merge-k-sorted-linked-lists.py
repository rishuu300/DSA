'''
class Node:
    def _init_(self, x):
        self.data = x
        self.next = None
'''

import heapq

class Solution:
    def mergeKLists(self, arr):
        heap = []
        
        for index, node in enumerate(arr):
            heapq.heappush(heap, (node.data, index, node))
        
        dummy = Node(0)
        tail = dummy
        
        while heap:
            _, index, node = heapq.heappop(heap)
            
            tail.next = node
            tail = tail.next
            
            if node.next:
                heapq.heappush(heap, (node.next.data, index, node.next))
        
        return dummy.next