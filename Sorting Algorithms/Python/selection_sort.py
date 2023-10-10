def selection_sort(arr):
    """
    Selection Sort Algorithm
    
    Parameters:
    - arr: List to be sorted
    """
    n = len(arr)
    
    # Traverse through all array elements
    for i in range(n):
        # Find the minimum element in the remaining unsorted array
        min_index = i
        for j in range(i+1, n):
            if arr[j] < arr[min_index]:
                min_index = j
                
        # Swap the found minimum element with the first element
        arr[i], arr[min_index] = arr[min_index], arr[i]

# Example Usage:
arr = [64, 25, 12, 22, 11]
selection_sort(arr)
print("Selection Sorted array:", arr)
