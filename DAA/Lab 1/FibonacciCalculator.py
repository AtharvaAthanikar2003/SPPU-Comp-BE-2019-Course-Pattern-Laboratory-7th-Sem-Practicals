def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n - 1) + fibonacci(n - 2)
def fibonacciIteration(n):
    fib = [0] * (n + 1)
    fib[0] = 0
    fib[1] = 1
    for i in range(2, n + 1):
        fib[i] = fib[i - 1] + fib[i - 2]
    return fib[n]
def stepCountRecursion(n):
    if n <= 1:
        return 1
    return stepCountRecursion(n - 1) + stepCountRecursion(n - 2)
def stepCountIteration(n):
    count = 0
    fib = [0] * (n + 1)
    fib[0] = 0
    fib[1] = 1
    for i in range(2, n + 1):
        fib[i] = fib[i - 1] + fib[i - 2]
        count += 1
    return count
n = int(input("Enter the number of Fibonacci numbers to calculate: "))
stepsRecursion = stepCountRecursion(n)
stepsIteration = stepCountIteration(n)
print("Fibonacci Recursion:", fibonacci(n))
print("Fibonacci Recursion Steps:", stepsRecursion)
print("Fibonacci Iteration:", fibonacciIteration(n))
print("Fibonacci Iteration Steps:", stepsIteration)

"""
Enter the number of Fibonacci numbers to calculate: 5
Fibonacci Recursion: 5
Fibonacci Recursion Steps: 8
Fibonacci Iteration: 5
Fibonacci Iteration Steps: 4
"""
