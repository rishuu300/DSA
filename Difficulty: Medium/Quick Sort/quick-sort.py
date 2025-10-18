class Solution:
    def quickSort(self, arr, low, high):
        if low < high:
            part = self.partition(arr, low, high)
            self.quickSort(arr, low, part)
            self.quickSort(arr, part+1, high)

    def partition(self, arr, low, high):
        pivot = arr[low]
        i, j = low - 1, high + 1
        
        while True:
            while True:
                i += 1
                if arr[i] >= pivot:
                    break
            
            while True:
                j -= 1
                if arr[j] <= pivot:
                    break
            
            if i >= j:
                return j
            
            arr[i], arr[j] = arr[j], arr[i]