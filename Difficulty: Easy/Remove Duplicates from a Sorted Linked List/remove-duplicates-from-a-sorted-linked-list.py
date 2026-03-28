def removeDuplicates(head):
    prev = head
    curr = head.next
    
    while curr:
        if curr.data != prev.data:
            prev.next = curr
            curr = curr.next
            prev = prev.next
        else:
            curr = curr.next
    
    prev.next = None