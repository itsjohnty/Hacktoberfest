def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    
    mid = len(arr)//2

    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    return merge(left, right)

def merge(left, right):
    i = 0
    j = 0
    ans = []
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            ans.append(left[i])
            i += 1
        else:
            ans.append(right[j])
            j += 1
    if i < len(left):
        ans.extend(left[i:])
    if j < len(right):
        ans.extend(right[j:])
    return ans


arr = [213,45,3246,235,6,2467,463,8548,77,5,64,5,63,64,7,468,24,532,65,37,3467,56,84578]
print(merge_sort(arr))
