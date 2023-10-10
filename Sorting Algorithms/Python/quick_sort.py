def quick_sort(arr):
    """
    Quick Sort Algorithm
    
    Parameters:
    - arr: List to be sorted
    """
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr[0]
        less = [x for x in arr[1:] if x <= pivot]
        greater = [x for x in arr[1:] if x > pivot]
        return quick_sort(less) + [pivot] + quick_sort(greater)

# Example Usage:
arr = [38, 27, 43, 3, 9, 82, 10]
arr = quick_sort(arr)
print("Quick Sorted array:", arr)
