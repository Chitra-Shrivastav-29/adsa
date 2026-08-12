def merge(arr, lb, mid, ub):
    b = [0] * len(arr)

    i = lb
    j = mid + 1
    k = lb

    while i <= mid and j <= ub:
        if arr[i] <= arr[j]:
            b[k] = arr[i]
            i += 1
        else:
            b[k] = arr[j]
            j += 1
        k += 1

    while i <= mid:
        b[k] = arr[i]
        i += 1
        k += 1

    while j <= ub:
        b[k] = arr[j]
        j += 1
        k += 1

    for k in range(lb, ub + 1):
        arr[k] = b[k]


def merge_sort(arr, lb, ub):
    if lb < ub:
        mid = (lb + ub) // 2
        merge_sort(arr, lb, mid)
        merge_sort(arr, mid + 1, ub)
        merge(arr, lb, mid, ub)


arr = [5, 24, 8, 1, 3, 16, 10, 20]
print("Original Array:", arr)
merge_sort(arr, 0, len(arr) - 1)
print("Sorted Array:", arr)
