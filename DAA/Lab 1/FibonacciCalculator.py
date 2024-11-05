def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)
def stepCountRecursion(n):
    if n <= 1:
        return 1
    return stepCountRecursion(n - 1) + stepCountRecursion(n - 2)
def printFibonacciSeriesRecursion(n):
    for i in range(n + 1):
        print(fibonacci(i), end=" ")
    print()
def fibonacciIteration(n):
    fib = [0] * (n + 1)
    fib[0] = 0
    fib[1] = 1
    for i in range(2, n + 1):
        fib[i] = fib[i - 1] + fib[i - 2]
    return fib[n]
def stepCountIteration(n):
    count = 0
    fib = [0] * (n + 1)
    fib[0] = 0
    fib[1] = 1
    for i in range(2, n + 1):
        fib[i] = fib[i - 1] + fib[i - 2]
        count += 1
    return count
def printFibonacciSeriesIteration(n):
    fib = [0] * (n + 1)
    fib[0] = 0
    fib[1] = 1
    for i in range(2, n + 1):
        fib[i] = fib[i - 1] + fib[i - 2]
    for i in range(n + 1):
        print(fib[i], end=" ")
    print()
if __name__ == "__main__":
    n = int(input("Enter the number of Fibonacci numbers to calculate: "))
    stepsRecursion = stepCountRecursion(n)
    print("Fibonacci Recursion:", fibonacci(n))
    print("Fibonacci Recursion Steps:", stepsRecursion)
    print("Fibonacci Series (Recursion):")
    printFibonacciSeriesRecursion(n)
    stepsIteration = stepCountIteration(n)
    print("Fibonacci Iteration:", fibonacciIteration(n))
    print("Fibonacci Iteration Steps:", stepsIteration)
    print("Fibonacci Series (Iteration):")
    printFibonacciSeriesIteration(n)

"""
Enter the number of Fibonacci numbers to calculate: 10
Fibonacci Recursion: 55
Fibonacci Recursion Steps: 89
Fibonacci Series (Recursion): 
0 1 1 2 3 5 8 13 21 34 55 
Fibonacci Iteration: 55
Fibonacci Iteration Steps: 9
Fibonacci Series (Iteration): 
0 1 1 2 3 5 8 13 21 34 55 
"""
