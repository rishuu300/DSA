class Solution:
    def merge(self, arr, l, m, r):
        n1 = m - l + 1
        n2 = r - m
        
        left = [0]*n1
        right = [0]*n2
        
        for i in range(0, n1):
            left[i] = arr[i+l]
        
        for i in range(0, n2):
            right[i] = arr[m+i+1]
        
        i, j, k = 0, 0, l
        
        while i<n1 and j<n2:
            if left[i] <= right[j]:
                arr[k] = left[i]
                i += 1
                k += 1
            else:
                arr[k] = right[j]
                j += 1
                k += 1
        
        while i<n1:
            arr[k] = left[i]
            i += 1
            k += 1
        
        while j<n2:
            arr[k] = right[j]
            j += 1
            k += 1
    
    def mergeSort(self, arr, l, r):
        if l < r:
            mid = l + (r-l) // 2
            self.mergeSort(arr, l, mid)
            self.mergeSort(arr, mid+1, r)
            self.merge(arr, l, mid, r)