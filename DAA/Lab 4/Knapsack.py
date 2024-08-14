def knap_sack(W, weights, values, items):
    table = [[0 for _ in range(W + 1)] for _ in range(items + 1)]
    for i in range(1, items + 1):
        for w in range(1, W + 1):
            if weights[i - 1] <= w:
                table[i][w] = max(values[i - 1] + table[i - 1][w - weights[i - 1]], table[i - 1][w])
            else:
                table[i][w] = table[i - 1][w]
    return table[items][W]
if __name__ == "__main__":
    values_input = input("Enter values of items (space-separated): ")
    values = list(map(int, values_input.split()))
    weights_input = input("Enter weights of items (space-separated): ")
    weights = list(map(int, weights_input.split()))
    W = int(input("Enter Knapsack Capacity: "))
    n = len(values)
    max_profit = knap_sack(W, weights, values, n)
    print(f"Maximum profit that can be achieved: {max_profit}")
