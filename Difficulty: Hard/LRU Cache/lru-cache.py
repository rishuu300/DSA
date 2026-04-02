class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.map = {}
        
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key):
        if key in self.map:
            node = self.map[key]
            self.remove(node)
            self.add(node)
            return node.value
        return -1

    def put(self, key, value):
        if key in self.map:
            self.remove(self.map[key])
        
        node = Node(key, value)
        self.add(node)
        self.map[key] = node
        
        if len(self.map) > self.capacity:
            lru = self.tail.prev
            self.remove(lru)
            del self.map[lru.key]

    def remove(self, node):
        prev_node = node.prev
        next_node = node.next
        
        prev_node.next = next_node
        next_node.prev = prev_node

    def add(self, node):
        next_node = self.head.next
        
        self.head.next = node
        node.prev = self.head
        
        node.next = next_node
        next_node.prev = node