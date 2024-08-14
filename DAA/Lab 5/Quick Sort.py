import random
def partition(arr, p, r):
    x = arr[r]
    i = p - 1
    for j in range(p, r):
        if arr[j] <= x:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i + 1], arr[r] = arr[r], arr[i + 1]
    return i + 1
def quick_sort(arr, p, r):
    if p < r:
        q = partition(arr, p, r)
        quick_sort(arr, p, q - 1)
        quick_sort(arr, q + 1, r)
def random_partition(arr, p, r):
    i = random.randint(p, r)
    arr[i], arr[r] = arr[r], arr[i]
    return partition(arr, p, r)
def randomized_quick_sort(arr, p, r):
    if p < r:
        q = random_partition(arr, p, r)
        randomized_quick_sort(arr, p, q - 1)
        randomized_quick_sort(arr, q + 1, r)
def main():
    input_str = input("Enter the list of numbers (space-separated): ")
    arr = list(map(int, input_str.split()))
    n = len(arr)
    randomized_quick_sort(arr, 0, n - 1)
    print(' '.join(map(str, arr)))
if __name__ == "__main__":
    main()
