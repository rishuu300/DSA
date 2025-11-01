class Solution:
    def merge(self, arr, l, m, r):
        n1 = m - l + 1
        n2 = r - m
        left = arr[l:m+1]
        right = arr[m+1:r+1]

        i = j = 0
        k = l
        count = 0

        while i < n1 and j < n2:
            if left[i] <= right[j]:
                arr[k] = left[i]
                i += 1
            else:
                arr[k] = right[j]
                j += 1
                count += (n1 - i)
            k += 1

        while i < n1:
            arr[k] = left[i]
            i += 1
            k += 1
        while j < n2:
            arr[k] = right[j]
            j += 1
            k += 1

        return count

    def mergeSort(self, arr, l, r):
        count = 0
        if l < r:
            m = (l + r) // 2
            count += self.mergeSort(arr, l, m)
            count += self.mergeSort(arr, m + 1, r)
            count += self.merge(arr, l, m, r)
        return count

    def inversionCount(self, arr):
        return self.mergeSort(arr, 0, len(arr) - 1)